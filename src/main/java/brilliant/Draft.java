package brilliant;


import brilliant.core.servlet.XBSocketServlet;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Created by: Yukai
 * @Date: 2019/1/22 22:14
 * @Description : Yukai is so handsome xxD
 */
public class Draft {
    public static void main(String[] args) throws Exception {
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

        Server server = new Server(9999);

        ServletContextHandler context = new ServletContextHandler();

        server.setHandler(context);

        server.start();

        context.addServlet(XBSocketServlet.class,"/akkk");
        context.addServlet(XBSocketServlet.class,"/akkk/aaa");

    }

    static class TryHandler extends AbstractHandler {

        @Override
        public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
            System.out.println("aa:" + s);
            request.setHandled(true);
        }
    }

    static class TryHandler_2 extends AbstractHandler {

        @Override
        public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
            System.out.println("bb:" + s);
            request.setHandled(true);
        }
    }
}
