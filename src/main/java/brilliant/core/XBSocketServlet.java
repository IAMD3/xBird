package brilliant.core;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import javax.servlet.annotation.WebServlet;
/**
 * @Created by: Yukai
 * @Date: 2019/1/21 0:12
 * @Description : choose either XBHandler/XBSocketServlet
 */
@SuppressWarnings("serial")
@WebServlet(name = "MyEcho WebSocket Servlet", urlPatterns = { "/hello" })
public class XBSocketServlet extends WebSocketServlet {

    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.getPolicy().setIdleTimeout(10L * 60L * 1000L);
        webSocketServletFactory.getPolicy().setAsyncWriteTimeout(10L * 1000L);
        /* set webSocketCreator xxDD */
        webSocketServletFactory.setCreator(new CoreCreator());
    }
}
