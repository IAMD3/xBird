package brilliant;

import brilliant.core.XBHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

import java.util.Arrays;

public class JettyServerLauncher {

    private static final int DEFAULT_PORT = 8089;
    private static Server server;

    public static void main(String[] args) throws Exception {
        System.out.println("args::" + Arrays.toString(args));
        JettyServerLauncher.startJetty(getPortFromArgs(args));
    }


    private static int getPortFromArgs(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.valueOf(args[0]);
            } catch (NumberFormatException ignore) {
                System.out.println(ignore);
            }
        }
        return DEFAULT_PORT;
    }

    private static void startJetty(int port) throws Exception {
        server = new Server(port);
        // trigger.setHandler(getWebAppContext());
        ContextHandler contextHandler = new ContextHandler();
        contextHandler.setContextPath("/abc");
        contextHandler.setHandler(new XBHandler());


        server.setHandler(new XBHandler());
        server.start();
        server.join();
    }

    public static void stopJetty() throws Exception {
        server.stop();
    }


}
