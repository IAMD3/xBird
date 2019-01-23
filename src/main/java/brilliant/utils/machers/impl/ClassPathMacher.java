package brilliant.utils.machers.impl;

import brilliant.utils.machers.XBMacher;

import java.util.regex.Pattern;

/**
 * @Created by: Yukai
 * @Date: 2019/1/23 11:12
 * @Description : Yukai is so handsome xxD
 */
public class ClassPathMacher implements XBMacher {
    // check if a given path is a class path or not
    //查看路径指向的文件是否是类文件
    @Override
    public boolean ifMatch(String target) {
        return Pattern.matches(".+\\.class", target);
    }
}
