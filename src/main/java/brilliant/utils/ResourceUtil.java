package brilliant.utils;

import brilliant.core.model.XBResource;
import brilliant.utils.machers.XBMacher;
import brilliant.utils.machers.impl.ClassPathMacher;
import brilliant.utils.parsers.StringParseUtil;
import brilliant.utils.parsers.TypeParseUtil;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:08
 * @Description : Yukai is so handsome xxD
 */
public class ResourceUtil {

    // recursively scan a directory and then assemble
    public static void assembleFileClasses(File dir, Set<File> container, XBMacher matcher) throws URISyntaxException {
        if (!dir.isDirectory() && matcher.ifMatch(dir.getAbsolutePath())) {
            container.add(dir);
            return;
        }

        File[] contents = dir.listFiles();
        if (contents == null) {
            return;
        }
        Arrays.sort(contents);
        for (File f : contents) {
            if (f.isDirectory()) {
                assembleFileClasses(f, container, matcher);
            } else {
                if (matcher.ifMatch(f.getAbsolutePath())) {
                    container.add(f);
                }
            }
        }
    }

    public static Set<XBResource> assembleXBResource(Collection<File> files, String packageName) {
        Set<XBResource> resources = new HashSet<>();

        files.stream().forEach(f -> {
            XBResource resource = new XBResource();

            String classPath = StringParseUtil.parseToUniversalFilePath(f.getAbsolutePath());
            // todo : bug!!!!
            // String qualifiedClassName = StringParseUtil.converToQualifiedClassName(classPath, packageName);
            // String classPackageName = StringParseUtil.convertToClassPackageName(qualifiedClassName);

            resource.setAbsoluteClassPath(classPath);
            resource.setFile(f);
            //resource.setQualifiedClassName(qualifiedClassName);
            //  resource.setPackageName(classPackageName);

            resources.add(resource);
        });

        return resources;
    }

    public static void assembleJarClasses(URL url, LinkedHashSet<File> fileContainer, ClassPathMacher classPathMacher) throws IOException, URISyntaxException {
        System.out.println("assemble jarClasses -----");
        //  System.out.println("file path:"+dir.getPath()+ "size: "+ dir.listFiles()==null?"0":String.valueOf(dir.listFiles().length));
        URLConnection con = url.openConnection();
        JarFile jarFile;
        String jarFileUrl;
        String rootEntryPath;
        boolean closeJarFile;
        JarEntry entry;
        if (con instanceof JarURLConnection) {
            JarURLConnection jarCon = (JarURLConnection) con;
            jarFile = jarCon.getJarFile();
            jarFileUrl = jarCon.getJarFileURL().toExternalForm();
            entry = jarCon.getJarEntry();
            rootEntryPath = entry != null ? entry.getName() : "";
            closeJarFile = !jarCon.getUseCaches();
        } else {
            System.out.println("ResourceUtil: not a jar file !!!!");
            //todo solve the file is not the format of "*.jar"
            rootEntryPath = "";
            jarFile = null;
            throw new RuntimeException("ResourceUtil: not a jar file !!!!");
        }

        if (!"".equals(rootEntryPath) && !rootEntryPath.endsWith("/")) {
            // Root entry path must end with slash to allow for proper matching.
            // The Sun JRE does not return a slash here, but BEA JRockit does.
            rootEntryPath = rootEntryPath + "/";
        }

        for (Enumeration<JarEntry> entries = jarFile.entries(); entries.hasMoreElements(); ) {
            JarEntry eentry = entries.nextElement();
            String entryPath = eentry.getName();
            if (entryPath.startsWith(rootEntryPath)) {
                String relativePath = entryPath.substring(rootEntryPath.length());
                if (classPathMacher.ifMatch(relativePath)) {
                    relativePath = relativePath.startsWith("/") ? relativePath.substring(1) : relativePath;
                    URL url_file = new URL(url, relativePath);
                    //   System.out.println("ResourceUtil: "+url_file);
                    fileContainer.add(TypeParseUtil.urlToFile(url_file));
                }
            }
        }

    }
}
