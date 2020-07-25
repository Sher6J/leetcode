package cn.sher6j.concurrrency;

import org.junit.Test;

import java.util.*;

/**
 * @author sher6j
 * @create 2020-07-24-11:47
 */
public class TestDemo {

    /**
     * java.util.ConcurrentModificationException
     * 对于单线程程序也会抛出该异常
     * 当对象直接从容器中删除（list.remove）而不是通过迭代器方法（iterator.remove）删除
     * 就会抛出并发修改异常
     */
    @Test
    public void testException() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            list.remove(0);
            System.out.println(iterator.next());
        }
    }

    /**
     * 21445286000
     * 11301824000
     * 17817100
     * 71198000
     * 537967600
     * 518495000
     * @throws InterruptedException
     */
    @Test
    public void LatchTest() throws InterruptedException {
        LatchDemo latchDemo = new LatchDemo();
        long l = latchDemo.timeTasks(10, new Runnable() {
            @Override
            public void run() {
                long sum = 0;
                for (int i = 0; i <= 999999999; i++) {
                    sum += i;
//                    System.out.println(Thread.currentThread().getName());
//                    System.out.println(sum);
                }
            }
        });
        System.out.println(l);
    }

    @Test
    public void testBoudedHashSet() throws InterruptedException {
        BoundedHashSet<Integer> set = new BoundedHashSet<>(3);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    try {
                        set.add(i);
                        System.out.println(Thread.currentThread().getName() + ":" + set);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    set.remove(i);
                    System.out.println(Thread.currentThread().getName() + ":" + set);
                }
            }
        };

    }

//    /**
//     * 4513116400
//     * 1016261500
//     * 4183900
//     * 45395400
//     * 406632600
//     * 311623800
//     */
//    @Test
//    public void test() {
//        long start = System.nanoTime();
//        long sum = 0;
//        for (int i = 0; i <= 999999999; i++) {
//            sum += i;
////            System.out.println(Thread.currentThread().getName());
////            System.out.println(sum);
//        }
//        long end = System.nanoTime();
//        System.out.println(end - start);
//    }
}
