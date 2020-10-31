package cn.sher6j.datastructure;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author sher6j
 * @create 2020-10-31-16:31
 */
public class Test {
    /**
     * 测试MyArrayList
     */
    @org.junit.Test
    public void testMyArrayList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        list.add(2, 5);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(3);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());
        list.trimToSize();
        System.out.println(Arrays.toString(list.toArray()));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
