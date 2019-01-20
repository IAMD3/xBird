package core;

import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * @Created by: Yukai
 * @Date: 2019/1/18 14:08
 * @Description : Yukai is so handsome xxD
 */
public class XBHandler extends WebSocketHandler {
    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.getPolicy().setIdleTimeout(10L * 60L * 1000L);
        webSocketServletFactory.getPolicy().setAsyncWriteTimeout(10L * 1000L);

        /* set webSocketCreator xxDD */
        webSocketServletFactory.setCreator(new CoreCreator());
    }
}
