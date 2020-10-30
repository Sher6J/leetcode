package cn.sher6j.designpattens.SingletonPatten;

/**
 * @author sher6j
 * @create 2020-10-30-18:31
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        if (instance1 == instance2) {
            System.out.println("ins1和ins2是相同的实例");
        } else {
            System.out.println("ins1和ins2不是相同的实例");
        }
        System.out.println("End.");
    }
}
