package core;

import core.emun.SocketType;
import core.socket.FastSocket;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by: Yukai
 * @Date: 2019/1/20 22:18
 * @Description : Yukai is so handsome xxD, the config of the XBSocket
 */
public class XBConfig {
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


    }

}

