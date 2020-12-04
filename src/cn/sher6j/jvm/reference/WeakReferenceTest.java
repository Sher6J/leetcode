package cn.sher6j.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * @author sher6j
 * @create 2020-12-04-20:57
 */
public class WeakReferenceTest {
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
        WeakReference<User> sher6j = new WeakReference<>(new User(1, "sher6j"));

        System.out.println(sher6j.get());

        /**
         * 无论内存充足与否，都会清除弱引用
         */

        System.gc();
        System.out.println("After GC:");
        System.out.println(sher6j.get());
    }
}
