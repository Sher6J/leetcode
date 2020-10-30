package cn.sher6j.test;

/**
 * @author sher6j
 * @create 2020-06-09-17:13
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
    }
    //linking.prepare：number = 0 --> initial: 20->10
    private static int number = 10;
    public static void main(String[] args) {
        System.out.println(ClassInitTest.num); //2
        System.out.println(ClassInitTest.number); //10
    }
}
