package core.socket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

/**
 * @Created by: Yukai
 * @Date: 2019/1/18 14:11
 * @Description :This is by far the most basic and best performing (speed and memory wise)
 * WebSocket implementation you can create.---quoted from Jetty official website
 */
public class FastSocket implements WebSocketListener {

    private Session session;

    @Override
    public void onWebSocketBinary(byte[] payload, int offset, int len) {
        /* only interested in text messages */
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        this.session = null;
    }

    @Override
    public void onWebSocketConnect(Session session) {
        this.session = session;
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        cause.printStackTrace(System.err);
    }

    @Override
    public void onWebSocketText(String message) {
        if ((session != null) && (session.isOpen())) {
            System.out.printf("Echoing back message [%s]%n", message);
            // echo the message back
            session.getRemote().sendString(message, null);
        }
    }
}