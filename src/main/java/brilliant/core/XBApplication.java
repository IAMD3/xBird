package brilliant.core;

import brilliant.core.initializer.XBInitializer;
import brilliant.core.model.XBResource;
import brilliant.utils.ResourceUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Created by: Yukai
 * @Date: 2019/1/23 14:01
 * @Description : Yukai is so handsome xxD
 */
public class XBApplication {

    private boolean isInit = false;
    private Set<XBResource> classResources;
    private Set<XBInitializer> intializers;

    public XBApplication(Class locator) throws IOException, URISyntaxException {
        if (!isInit) {
            // return a Set obj with 0 element if no *.class file scanned
            Set<File> files = XBScanner.scanClass(locator);
            // param1: resource & param2 : split point
            classResources = ResourceUtil.assembleXBResource(files,locator.getPackage().getName());


            for (XBInitializer initializer : intializers) {
                initializer.doInit();

            }
        }


        isInit = true;
    }


}
