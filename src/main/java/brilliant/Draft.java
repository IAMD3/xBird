package brilliant;


import brilliant.tool.XBScanner;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:14
 * @Description : Yukai is so handsome xxD
 */
public class Draft {
    public static void main(String[] args) throws IOException {
        //System.out.println((char)42);
        //System.out.println((char)63);
        String pName =Draft.class.getPackage().getName();
        Set<URL> urls = XBScanner.findClassDefiniationNames(pName);
    }
}
