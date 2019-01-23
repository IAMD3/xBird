package brilliant.utils;

import brilliant.utils.machers.XBMacher;
import brilliant.utils.machers.impl.ClassPathMacher;

import java.io.File;
import java.util.Arrays;
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
        if(contents==null){
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
}
