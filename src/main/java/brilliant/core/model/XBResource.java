package brilliant.core.model;



import java.io.File;

/**
 * @Created by: Yukai
 * @Date: 2019/1/23 15:13
 * @Description : Yukai is so handsome xxD
 */

public class XBResource {
    private File file;
    private String className;
    private String packageName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
