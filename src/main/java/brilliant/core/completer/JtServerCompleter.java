package brilliant.core.completer;

import brilliant.core.XBApplication;
import brilliant.core.fun.XBPluginFun;
import brilliant.core.model.XBResource;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/24 16:19
 * @Description : Yukai is so handsome xxD
 */
public class JtServerCompleter implements XBPluginFun<XBApplication, String[]> {
    @Override
    public void run(XBApplication app, String[] strings) throws Exception {

        // iterate the resources to generate the class
        Set<XBResource> resources = app.getResources();


        Object handler_obj = app.getContainer().get("org.eclipse.jetty.servlet.ServletContextHandler");

        if (handler_obj == null || !(handler_obj instanceof ServletContextHandler)) return;

        ServletContextHandler contextHandler = (ServletContextHandler) handler_obj;


    }
}
