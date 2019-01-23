package brilliant.utils;

import brilliant.core.model.XBResource;
import brilliant.utils.machers.XBMacher;
import brilliant.utils.parsers.StringParseUtil;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:08
 * @Description : Yukai is so handsome xxD
 */
public class ResourceUtil {

    // recursively scan a directory and then assemble
    public static void assembleClassFiles(File dir, Set<File> container, XBMacher matcher) {

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
                assembleClassFiles(f, container, matcher);
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
            String qualifiedClassName = StringParseUtil.converToQualifiedClassName(classPath, packageName);
            String classPackageName = StringParseUtil.convertToClassPackageName(qualifiedClassName);

            resource.setAbsoluteClassPath(classPath);
            resource.setFile(f);
            resource.setClassName(qualifiedClassName);
            resource.setPackageName(classPackageName);

            resources.add(resource);
        });

        return resources;
    }
}
