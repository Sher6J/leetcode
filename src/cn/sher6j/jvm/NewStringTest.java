package cn.sher6j.jvm;

import org.junit.Test;

/**
 * @author sher6j
 * @create 2020-12-03-18:25
 */
public class NewStringTest {

    /**
     * new String("sher6j") 会创建几个对象？
     * 两个
     * ① new 在堆空间中创建的 s 对象
     * ② 常量池中的 "sher6j" 对象
     *  0 new #2 <java/lang/String>    ①
     *  3 dup
     *  4 ldc #3 <sher6j>              ②
     *  6 invokespecial #4 <java/lang/String.<init>>
     *  9 astore_1
     * 10 return
     */
    @Test
    public void test1() {
        String s = new String("sher6j");
    }

    /**
     * 如下代码创建几个对象呢？
     * 6个
     *
     * test2字节码：
     *
     *  0 new #5 <java/lang/StringBuilder>                       ①
     *  3 dup
     *  4 invokespecial #6 <java/lang/StringBuilder.<init>>
     *  7 new #2 <java/lang/String>                              ②
     * 10 dup
     * 11 ldc #7 <sher>                                          ③
     * 13 invokespecial #4 <java/lang/String.<init>>
     * 16 invokevirtual #8 <java/lang/StringBuilder.append>
     * 19 new #2 <java/lang/String>                              ④
     * 22 dup
     * 23 ldc #9 <6j>                                            ⑤
     * 25 invokespecial #4 <java/lang/String.<init>>
     * 28 invokevirtual #8 <java/lang/StringBuilder.append>
     * 31 invokevirtual #10 <java/lang/StringBuilder.toString>
     * 34 astore_1
     * 35 return
     *
     * 再深入StringBuilder的toString方法：
     * @Override
     * public String toString() {
     *     // Create a copy, don't share the array
     *     return new String(value, 0, count);
     * }
     *
     * 其字节码为：
     *  0 new #80 <java/lang/String>                            ⑥
     *  3 dup
     *  4 aload_0
     *  5 getfield #234 <java/lang/StringBuilder.value>
     *  8 iconst_0
     *  9 aload_0
     * 10 getfield #233 <java/lang/StringBuilder.count>
     * 13 invokespecial #291 <java/lang/String.<init>>
     * 16 areturn
     *
     * 也就是说 "sher"、"6j" 在常量池中
     * 而 "sher6j" 不在常量池中
     */
    @Test
    public void test2() {
        String s = new String("sher") + new String("6j");
    }


    @Test
    public void test3() {
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2); //

//        String s3 = new String("1") + new String("1");//s3变量记录的地址为：new String("11")
//        //执行完上一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
//        s3.intern();//在字符串常量池中生成"11"。如何理解：
//        //jdk6:创建了一个新的对象"11",也就有新的在常量池中的地址。
//        //jdk7:此时常量中并没有创建"11",而是创建一个指向堆空间中new String("11")的地址，两个地址相同
//        String s4 = "11";//s4变量记录的地址：使用的是上一行代码代码执行时，在常量池中生成的"11"的地址
//        System.out.println(s3 == s4);//jdk6：false  jdk7/8：true

        String s = new String("1") + new String("1");
        s.intern();
        String s1 = "11";
        System.out.println(s == s1);
    }
}
