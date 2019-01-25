package brilliant.utils.parsers;


import java.io.File;
import java.util.Arrays;
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

    // return qualifiedClass name via a given super packageName(obtained by the class which is the input for the scanner)
    // 生成类完整名
    public static String converToQualifiedClassName(String absolutePath, String packageName) {
        int firstOccurredIndex = absolutePath.indexOf(StringParseUtil.convertToResourcePath(packageName));
        System.out.println("package name is "+packageName);
        System.out.println("first occured index is :"+firstOccurredIndex);
        return convertToPackageName(absolutePath.substring(firstOccurredIndex));
    }

    //  brilliant.core.CoreCreator - > brilliant.core
    public static String convertToClassPackageName(String qualifiedClassName) {
        String[] pieces = qualifiedClassName.split("\\.");

        if (pieces == null || pieces.length == 0) {
            return qualifiedClassName;
        } else if (pieces.length == 1) {
            return pieces[0];
        }

        List<String> piecesList = Arrays.asList(Arrays.copyOf(pieces, pieces.length - 1));

        StringBuilder sb = new StringBuilder();
        piecesList.forEach(str -> sb.append(str + "."));
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
