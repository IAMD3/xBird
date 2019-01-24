package brilliant.core.model;


import java.io.File;

/**
 * @Created by: Yukai
 * @Date: 2019/1/23 15:13
 * @Description : Yukai is so handsome xxD
 */

public class XBResource {
    private File file;
    private String qualifiedClassName;
    private String packageName;
    private String absoluteClassPath;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getQualifiedClassName() {
        return qualifiedClassName;
    }

    public void setQualifiedClassName(String qualifiedClassName) {
        this.qualifiedClassName = qualifiedClassName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAbsoluteClassPath() {
        return absoluteClassPath;
    }

    public void setAbsoluteClassPath(String absoluteClassPath) {
        this.absoluteClassPath = absoluteClassPath;
    }
}
