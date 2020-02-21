package IOStream.File;

import java.io.File;
import java.io.FileFilter;

//文件过滤器接口的实现类,accept的返回值是布尔值
public class FileFilterImpl  implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()){
            return true;
        }
        return pathname.getPath().endsWith(".txt");
    }
}
