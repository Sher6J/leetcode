package cn.sher6j.jvm.classloader;

import org.junit.Test;

/**
 * @author sher6j
 * @create 2020-12-05-20:45
 */
public class NotInitializationTest {
    /**
     * 通过子类引用父类的静态字段，不会导致子类初始化
     */
    @Test
    public void test1() {
        System.out.println(SubClass.val);
    }

    /**
     * 通过数组定义来引用类，不会触发类的初始化
     */
    @Test
    public void test2() {
        SuperClass[] sca = new SuperClass[10];
    }

    /**
     * 常量在编译阶段会存入 调用类 的常量池中，
     * 本质上没有直接引用到 定义常量的类，
     * 因此不会触发 定义常量的类 的初始化
     */
    @Test
    public void test3() {
        System.out.println(ConstClass.SHER6J);
    }
}
