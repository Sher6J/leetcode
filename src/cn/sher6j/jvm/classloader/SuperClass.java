package cn.sher6j.jvm.classloader;

/**
 * @author sher6j
 * @create 2020-12-05-20:43
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int val = 123;
}
