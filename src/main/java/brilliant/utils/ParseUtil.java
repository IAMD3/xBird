package brilliant.utils;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:43
 * @Description : Yukai is so handsome xxD
 */
public class ParseUtil {
    public static String covertClassNameToResourcePath(String classFullName) {
        return classFullName.replace('.', '/');
    }
}
