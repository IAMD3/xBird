package brilliant.utils.parsers;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @Created by: Yukai
 * @Date: 2019/1/23 10:12
 * @Description : Yukai is so handsome xxD
 */
public class TypeParseUtil {

    public static File urlToFile(URL url) throws URISyntaxException {
        return new File(url.toURI());
    }
}
