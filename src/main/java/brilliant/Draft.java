package brilliant;


import brilliant.core.XBApplication;
import brilliant.core.XBScanner;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:14
 * @Description : Yukai is so handsome xxD
 */
public class Draft {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //System.out.println((char)42);
        //System.out.println((char)63);
     /*   String pName =Draft.class.getPackage().getName();
        Set<URL> urls = XBScanner.findClassDefiniationNames(pName);
        System.out.println("aba".replace("a","k"));*/
  /*   String str= "C:\\Users\\Yukai\\Desktop\\newGroup\\project\\spring-boot\\spring-boot-samples\\demo\\target\\classes\\com\\example\\demo.class";
        System.out.println(ClassPathMacher.isClassPath(str));
  */

      /*  String path = "C:\\Users\\Yukai\\Desktop\\newGroup\\project\\xbird\\src\\main\\java\\brilliant\\core\\XBHandler.java";
        String path_parse= StringParseUtil.parseToUniversalFilePath(path);
        File file = new File(path_parse);
        File[] files = file.listFiles();
*/

        new XBApplication(Draft.class);
    }
}
