package cn.sher6j.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 * @author sher6j
 * @create 2020-12-04-20:38
 */
public class SoftReferenceTest {
    public static class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 建立软引用，如下一行代码等价于下面的三行代码
        SoftReference<User> sher6j = new SoftReference<>(new User(1, "sher6j"));
//        User sher6j = new User(1, "sher6j");
//        SoftReference<User> userSoftReference = new SoftReference<>(sher6j);
//        sher6j = null; // 取消强引用

        // get方法获取弱引用封装的实体对象
        System.out.println(sher6j.get()); // User{id=1, name='sher6j'}

        /**
         * 内存足够时，不会清除软引用
         * 内存不够时，才会清除软引用
         */

        System.gc();
        System.out.println("After GC：");
        System.out.println(sher6j.get());

        // 让系统认为内存资源紧张
        try {
            byte[] b = new byte[1024 * 1024 * 7];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(sher6j.get()); // null
        }
    }
}
