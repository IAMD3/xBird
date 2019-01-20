package core;

import core.socket.FastSocket;
import core.socket.XBSocket;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

import java.lang.reflect.Field;

/**
 * @Created by: Yukai
 * @Date: 2019/1/18 14:11
 * @Description : Yukai is so handsome xxD
 */
public class CoreCreator implements WebSocketCreator {

    private XBSocket xbSocket;
    private FastSocket fastSocket;

    public CoreCreator() {
        this.xbSocket = new XBSocket();
        this.fastSocket = new FastSocket();
    }

    // just a simple frame for extending the functionality
    @Override
    public Object createWebSocket(ServletUpgradeRequest request, ServletUpgradeResponse response) {
        // apply the specified socket if the name of the `socketType` delivered from remote endpoint xxDD
        String socketType = request.getParameterMap().get("socketType").get(0);

        for (String sub : request.getSubProtocols()) {

        }
        // apply the first element of the typeList if `singleType` feature applied
        if (XBConfig.singleType) {
            switch (XBConfig.types.get(0)) {
                case fastSocket:
                    return fastSocket;
                case XBSocket:
                    return xbSocket;
                default:
                    return fastSocket;
            }
        }

        if (socketType != null && !socketType.equals("")) {
            Class<CoreCreator> clazz = CoreCreator.class;
            try {
                Field field = clazz.getDeclaredField(socketType);
                field.setAccessible(true);
                return  field.get(this);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return fastSocket;
            }
        }
        return  fastSocket;
    }
}
