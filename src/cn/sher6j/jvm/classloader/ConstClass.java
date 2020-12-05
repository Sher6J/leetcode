package cn.sher6j.jvm.classloader;

/**
 * @author sher6j
 * @create 2020-12-05-20:47
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String SHER6J = "sher6j";
}
