package brilliant.tool;

import brilliant.utils.ResourceUtil;
import brilliant.utils.machers.impl.ClassPathMacher;
import brilliant.utils.parsers.StringParseUtil;
import brilliant.utils.parsers.TypeParseUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/21 16:39
 * @Description : Yukai is so handsome xxD
 */
public class XBScanner {
    // a public method for loading a java.lang.Class obj and return an assembled collection
    // 对外开放方法，基于Class对象确定根路径并且递归扫描获取所有类对象——唐架构真帅
    public static Set<File> scanClass(Class clazz) throws IOException, URISyntaxException {
        LinkedHashSet<File> fileContainer = new LinkedHashSet<>();

        String packageName = clazz.getPackage().getName();
        Set<URL> urls = findUrls(packageName);

        for (URL url : urls) {
            File file = TypeParseUtil.urlToFile(url);
            ResourceUtil.assembleClassFiles(file, fileContainer, new ClassPathMacher());
        }

        return fileContainer;
    }

    //retrieve urls via a given package name
    // 通过包名获取Urls对象集合
    //basePackage - > relative path -> getResources(with the help of classloader)
    //Yukai is awesome !
    private static Set<URL> findUrls(String basePackage) throws IOException {
        String packagePath = StringParseUtil.covertPackageNameToResourcePath(basePackage);

        return findResources(packagePath);
    }

    private static Set<URL> findResources(String packagePath) throws IOException {
        Set<URL> result = new LinkedHashSet();
        ClassLoader cl = XBScanner.class.getClassLoader();

        Enumeration resourceUrls = cl != null ? cl.getResources(packagePath) : ClassLoader.getSystemResources(packagePath);

        while (resourceUrls.hasMoreElements()) {
            URL url = (URL) resourceUrls.nextElement();
            result.add(url);
        }

        return result;
    }


}
