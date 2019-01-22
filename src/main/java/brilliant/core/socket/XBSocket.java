package brilliant.core.socket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * @Created by: Yukai
 * @Date: 2019/1/18 14:11
 * @Description :
 */
@WebSocket(maxTextMessageSize = 128 * 1024, maxBinaryMessageSize = 128 * 1024)
public class XBSocket {

    @OnWebSocketConnect
    public void onText(Session session)throws  Exception{
        if(session.isOpen()){
            session.getRemote().sendString("websocket::open");
            System.out.println("websocket::open");

        }
    }

    @OnWebSocketClose
    public void onWebSocketBinary(int i,String string)
    {
        System.out.println("关闭");



    }




}
