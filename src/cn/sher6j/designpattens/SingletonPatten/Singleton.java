package cn.sher6j.designpattens.SingletonPatten;

/**
 * DCL 单例
 * @author sher6j
 * @create 2020-10-30-18:29
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    System.out.println("生成一个实例");
                }
            }
        }
        return instance;
    }
}
