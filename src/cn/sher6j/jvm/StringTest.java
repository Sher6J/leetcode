package cn.sher6j.jvm;

import org.junit.Test;

/**
 * @author sher6j
 * @create 2020-12-03-16:08
 */

public class StringTest {
    @Test
    public void test1() {

        // 都是字符串常量池中的 "abc"

        String s1 = "a" + "b" + "c"; // 常量与常量的拼接其结果直接在常量池中，原理是编译期优化
        String s2 = "abc";

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // true
    }

    @Test
    public void test2() {
        String s1 = "java";
        String s2 = "python";

        String s3 = "javapython";
        String s4 = "java" + "python"; // 编译期优化直接在常量池
        String s5 = s1 + "python";
        String s6 = "java" + s2;
        String s7 = s1 + s2;

        // 若拼接号前后出现了变量，则相当于在堆空间中（非字符串常量池）new String()，即创建了新对象，具体内容为拼接后结果

                                      //  自己预测      实际
        System.out.println(s3 == s4); //   true
        System.out.println(s3 == s5); //   false
        System.out.println(s3 == s6); //   false
        System.out.println(s3 == s7); //   false
        System.out.println(s5 == s6); //   false
        System.out.println(s5 == s7); //   false
        System.out.println(s6 == s7); //   false

        String s8 = s6.intern();
        System.out.println(s3 == s8); //   true
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4); // false
    }

    @Test
    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4); // true
    }


    // 测试字符串拼接和StringBuilder的效率
    @Test
    public void test5() {
        long start1 = System.currentTimeMillis();
        method1(200000);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        method2(200000);
        long end2 = System.currentTimeMillis();

        long start3 = System.currentTimeMillis();
        method3(200000);
        long end3 = System.currentTimeMillis();

        System.out.println(end1 - start1); // 10983
        System.out.println(end2 - start2); // 5
        System.out.println(end3 - start3); // 4
    }

    public void method1(int n) {
        String s = "";
        // 每次循环都会创建一个StringBuilder，而且最后还都会调用约等于 sb.toString() 返回
        for (int i = 0; i < n; i++) {
            s = s + "a";
        }
    }

    public void method2(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }

    public void method3(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }
}
