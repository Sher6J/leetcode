package cn.sher6j.jvm.rumtime;

/**
 * @author sher6j
 * @create 2020-11-28-16:30
 */
public class StackTest {
    public static void main(String[] args) {
        StackTest test = new StackTest();
        test.a();
    }

    public void a() {
        int i = 10;
        int j = 20;
        b();
    }

    public void b() {
        int k = 30;
        int m = 40;
    }
}
