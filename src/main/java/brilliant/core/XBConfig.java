package brilliant.core;

import brilliant.core.emun.SocketType;
import brilliant.core.socket.FastSocket;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by: Yukai
 * @Date: 2019/1/20 22:18
 * @Description : Yukai is so handsome xxD, the config of the XBSocket
 */
public class XBConfig {
    // if embedded into a framework or triiger the server independently
    public static boolean isEmbedded;
    // the port of the server (in case the attribute `isEmbedded = false`)
    public static int port;

    // if use the functionality of the webSocket or not xxxDD
    public static boolean ifUse;
    // the collection of the types
    public static List<SocketType> types;
    // if only use one type or multiple types(use the first SocketType of the list)
    public static boolean singleType;
    // if using annotation xxDD
    public static boolean ifAnno;

    static {
        ifUse = true;
        ifAnno = true;
        singleType = true;

        types = new ArrayList<SocketType>();
        types.add(SocketType.fastSocket);
        types.add(SocketType.XBSocket);
        types.add(SocketType.YkSocket);


        // server config
        isEmbedded = false;

        if (!isEmbedded) {
            port = 9999;
        }
    }

}

