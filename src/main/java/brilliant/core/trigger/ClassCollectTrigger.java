package brilliant.core.trigger;

import brilliant.core.XBApplication;
import brilliant.core.fun.XBPluginFun;
import brilliant.core.model.XBResource;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/24 17:15
 * @Description : Yukai is so handsome xxD
 */
public class ClassCollectTrigger implements XBPluginFun<XBApplication, String[]> {
    @Override
    public void run(XBApplication app, String[] strings) throws Exception {
        // put a Class collection to XBContainer xxDDD
        // 向XBContainer 添加一个扫描到的类集合
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

        app.getContainer().put("java.util.LinkedHashSet$classes", classes);
    }
}
