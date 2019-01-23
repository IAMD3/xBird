package brilliant.utils.parsers;


import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:43
 * @Description : Yukai is so handsome xxD
 */
public class StringParseUtil {
    //package name to resource path name
    //包名 -> 包相对路径名
    public static String convertToResourcePath(String packageName) {
        return packageName.replace('.', '/');
    }

    // resource path name to package name
    //类相对路径名->类名
    public static String convertToPackageName(String relativeClassPath) {
        return relativeClassPath.replace('/', '.');
    }


    // make filepath suitable for both unix & windows operation system xxxDDD
    // 使路径名可以被多系统识别,唐架构真帅！
    public static String parseToUniversalFilePath(String filePath) {
        return filePath.replace(File.separator, "/");
    }

    public static String converToQualifiedClassName(String absolutePath, String packageName) {
        String[] relativeClassPaths = absolutePath.split(StringParseUtil.convertToResourcePath(packageName));
        String qualifiedClassPath = relativeClassPaths.length > 1 ? relativeClassPaths[1] : relativeClassPaths[0];
        return convertToPackageName(qualifiedClassPath);
    }

    //  brilliant.core.CoreCreator - > brilliant.core
    public static String convertToClassPackageName(String qualifiedClassName) {
        String[] pieces = qualifiedClassName.split("\\.");

        if (pieces == null || pieces.length == 0) {
            return qualifiedClassName;
        } else if (pieces.length == 1) {
            return pieces[0];
        }

        List<String> piecesList = Arrays.asList(pieces);
        piecesList.remove(piecesList.size() - 1);

        StringBuilder sb = new StringBuilder();
        piecesList.forEach(str -> sb.append(str + "."));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
