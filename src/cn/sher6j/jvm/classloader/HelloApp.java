package cn.sher6j.jvm.classloader;

/**
 * @author sher6j
 * @create 2020-11-28-11:49
 */
public class HelloApp {
    private static int a = 1; // prepare环节：a=0; Initialization环节：a = 1

    static {
        a = 2;
        b = 20;
    }

    private static int b = 10;
    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
    }
}
