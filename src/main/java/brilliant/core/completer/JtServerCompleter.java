package brilliant.core.completer;

import brilliant.anno.FastSocket;
import brilliant.core.XBApplication;
import brilliant.core.fun.FunAB;
import brilliant.core.fun.XBPluginFun;
import brilliant.core.model.XBResource;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/24 16:19
 * @Description : Yukai is so handsome xxD
 */
public class JtServerCompleter implements XBPluginFun<XBApplication, String[]> {
    @Override
    public void run(XBApplication app, String[] strings) throws Exception {
        // retrieve the context handler from the container
        //从XB容器中获取Jetty上下文处理器对象 ——唐架构真帅 ！！！！！
        Object handler_obj = app.getContainer().get("org.eclipse.jetty.servlet.ServletContextHandler");

        if (handler_obj == null || !(handler_obj instanceof ServletContextHandler)) return;

        ServletContextHandler contextHandler = (ServletContextHandler) handler_obj;
        // analyse the annotation from the XBResource xxxDDDDD
        // 对XBResource对象进行注解分析与反射—唐架构真帅！！！！！
        LinkedHashSet<Class> classes = new LinkedHashSet<>();
        Set<XBResource> resources = app.getResources();
        // assemble the class collection
        resources.forEach(res -> {
            try {
                classes.add(Class.forName(res.getQualifiedClassName()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        for (Class clazz : classes) {
            Annotation fastSocket = clazz.getAnnotation(FastSocket.class);
           // clazz.getAnnotation()
        }
    }
}
