package brilliant.utils.parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        //  return new File(url.toURI());
        //URL [null]
       // return  ResourceUtils.getFile(url, this.getDescription());
        return new File(new URI(url.toString().replace(" ","%20")).getSchemeSpecificPart());
    }

   /* public static URI toURI(String location) throws URISyntaxException {
        return new URI(StringUtils.replace(location, " ", "%20"));
    }*/
  /* public static File getFile(URL resourceUrl, String description) throws FileNotFoundException {
       Assert.notNull(resourceUrl, "Resource URL must not be null");
       if (!"file".equals(resourceUrl.getProtocol())) {
           throw new FileNotFoundException(description + " cannot be resolved to absolute file path because it does not reside in the file system: " + resourceUrl);
       } else {
           try {
               return new File(toURI(resourceUrl).getSchemeSpecificPart());
           } catch (URISyntaxException var3) {
               return new File(resourceUrl.getFile());
           }
       }
   }*/

}
