package brilliant.core;

import brilliant.core.fun.XBPluginFun;
import brilliant.core.initializer.XBInitializer;
import brilliant.core.model.XBResource;
import brilliant.core.trigger.JtServerTrigger;
import brilliant.utils.ResourceUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/23 14:01
 * @Description : Yukai is so handsome xxD
 */
public class XBApplication {

    private boolean isInit = false;
    private Set<XBResource> resources;
    private Set<XBInitializer> initializers;
    private Set<XBPluginFun<XBApplication, String[]>> triggers;
    private Set<XBPluginFun<XBApplication, String[]>> completers;
    private Map<String, Object> container = new HashMap<String, Object>();

    public XBApplication(Class locator, String args[]) throws Exception {
        if (!isInit) {
            // return a Set obj with 0 element if no *.class file scanned
            Set<File> files = XBScanner.scanClass(locator);
            // param1: resource & param2 : split point
            resources = ResourceUtil.assembleXBResource(files, locator.getPackage().getName());

            // initialization components
            initializers.forEach(ini -> ini.doInit());

            // initiate triggers
            initTriggers(this, args);


        }


        isInit = true;
    }


    public void initTriggers(XBApplication app, String[] args) throws Exception {
        // todo the triggers should be read from IoC file
        triggers.add(new JtServerTrigger());

        for (XBPluginFun<XBApplication, String[]> e : triggers) {
            e.run(app, args);
        }
    }

    public void completeTrigger(XBApplication app, String[] args) {

    }


    public Set<XBResource> getResources() {
        return resources;
    }

    public void setResources(Set<XBResource> resources) {
        this.resources = resources;
    }

    public Set<XBInitializer> getInitializers() {
        return initializers;
    }

    public void setInitializers(Set<XBInitializer> initializers) {
        this.initializers = initializers;
    }


    public Map<String, Object> getContainer() {
        return container;
    }

    public void setContainer(Map<String, Object> container) {
        this.container = container;
    }
}
