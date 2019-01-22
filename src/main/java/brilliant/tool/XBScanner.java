package brilliant.tool;

import brilliant.utils.*;
import java.io.IOException;
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

    public static Set<URL> findClassDefiniationNames(String basePackage) throws IOException {
        LinkedHashSet<URL> urls = new LinkedHashSet<>();
        String packagePath= ParseUtil.covertClassNameToResourcePath(basePackage);

        return findResources(packagePath);
    }

    private static Set<URL> findResources(String packagePath) throws IOException {
        Set<URL> result = new LinkedHashSet();
        ClassLoader cl = XBScanner.class.getClassLoader();

        Enumeration resourceUrls = cl != null ? cl.getResources(packagePath) : ClassLoader.getSystemResources(packagePath);

        while(resourceUrls.hasMoreElements()) {
            URL url = (URL)resourceUrls.nextElement();
            result.add(url);
        }

        return result;
    }

}
