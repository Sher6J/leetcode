package cn.sher6j.jvm.classloader;

/**
 * @author sher6j
 * @create 2020-12-05-20:44
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}
