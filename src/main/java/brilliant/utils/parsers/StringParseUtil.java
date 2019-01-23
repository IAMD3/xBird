package brilliant.utils.parsers;


import com.sun.xml.internal.ws.util.StringUtils;
import org.eclipse.jetty.util.StringUtil;

import java.io.File;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:43
 * @Description : Yukai is so handsome xxD
 */
public class StringParseUtil {
    //package name to resource path name
    //包名 -> 包相对路径名
    public static String covertPackageNameToResourcePath(String packageName) {
        return packageName.replace('.', '/');
    }

    // make filepath suitable for both unix & windows operation system xxxDDD
    // 使路径名可以被多系统识别,唐架构真帅！
    public static String parseUniversalFilePath(String filePath) {
        return filePath.replace(File.separator, "/");
    }
}
