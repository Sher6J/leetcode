package cn.sher6j.jvm.classloader;

import cn.sher6j.test.ClassInitTest;
import sun.misc.Launcher;

import java.net.URL;

/**
 * @author sher6j
 * @create 2020-11-28-12:46
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        // 对于用户自定义类，默认使用系统类加载器加载
        ClassLoader classLoader = ClassInitTest.class.getClassLoader();
        System.out.println(classLoader);

        // 系统的核心类库都是用引导类加载器加载
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

        System.out.println("=================================");


        System.out.println("引导类加载器加载的路径：");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url);
        }

        System.out.println("扩展类加载器加载的路径：");
        String extDirs = System.getProperty("java.ext.dirs");
        System.out.println(extDirs);
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
    }
}
