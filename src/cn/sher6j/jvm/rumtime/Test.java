package cn.sher6j.jvm.rumtime;

/**
 * @author sher6j
 * @create 2020-12-03-19:02
 */
public class Test {
    public static void main(String[] args) {
        String s = new String("1") + new String("1");
        s.intern();
        String s1 = "11";
        System.out.println(s == s1);
    }
}
