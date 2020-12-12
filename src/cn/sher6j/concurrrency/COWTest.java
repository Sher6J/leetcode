package cn.sher6j.concurrrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sher6j
 * @create 2020-12-12-14:31
 */
public class COWTest {
    // 39083400
    @Test
    public void test1() {
        List<Long> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 20 * 10000; i++) {
            list.add(System.nanoTime());
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    // 15029435200
    @Test
    public void test2() {
        List<Long> list = new CopyOnWriteArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 20 * 10000; i++) {
            list.add(System.nanoTime());
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    // 44368000
    @Test
    public void test3() {
        List<Long> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 20 * 10000; i++) {
            list.add(System.nanoTime());
        }
        List<Long> cow = new CopyOnWriteArrayList<>(list);
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
