package cn.sher6j.jvm;

/**
 * 演示栈中的异常：StackOverflowError
 *  默认情况：count = 11412时开始异常 java.lang.StackOverflowError
 *  设置栈大小为256k，count = 2464
 * @author sher6j
 * @create 2020-06-12-16:44
 */
public class StackOverflowErrorTest {
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
