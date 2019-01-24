package brilliant.core.trigger;

import brilliant.core.XBApplication;
import brilliant.core.XBConfig;
import brilliant.core.fun.XBPluginFun;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @Created by: Yukai
 * @Date: 2019/1/24 11:01
 * @Description : Yukai is so handsome xxD
 */
public class JtServerTrigger implements XBPluginFun<XBApplication, String[]> {
    @Override
    public void run(XBApplication app, String[] args) throws Exception {
        Server server;

        if (!XBConfig.isEmbedded) {
            server = new Server(XBConfig.port);
        } else {
            server = new Server();
        }

        ServletContextHandler context = new ServletContextHandler();

        server.setHandler(context);
        server.join();
        server.start();

        app.getContainer().put("org.eclipse.jetty.servlet.ServletContextHandler",context);
    }


}
