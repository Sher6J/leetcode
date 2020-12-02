package cn.sher6j.jvm.rumtime;

/**
 * @author sher6j
 * @create 2020-12-02-15:27
 */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("Xms:" + initialMemory + "m");
        System.out.println("Xmx:" + maxMemory + "m");
        System.out.println("系统内存：" + initialMemory * 64.0 / 1024 + "G");
        System.out.println("系统内存：" + maxMemory * 4.0 / 1024 + "G");
    }
}
