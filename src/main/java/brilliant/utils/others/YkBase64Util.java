package brilliant.utils.others;

import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * Date: 2019/1/8
 * Time: 17:10
 * Author: Yukai
 * Description: 凯哥出品，必属精品
 **/
public class YkBase64Util {

    //读取base64,转换成Spring中的Base64ToMultipartFile对象
    public static InputStream readBase64(String base64) throws IOException {
        //切割base64中的前缀,strs[0]=header,strs[1];为imageContent
        String[] strs = base64.split(",");
        //原生decoder
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(strs[1]);

        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }

        return new ByteArrayInputStream(b);

    }

}
