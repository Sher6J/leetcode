package cn.sher6j.test;

import org.junit.Test;

/**
 * @author sher6j
 * @create 2020-12-10-14:52
 */
public class BasicType {
    @Test
    public void testShort() {
        short s = 1;
        /**
         * Required type:
         * short
         * Provided:
         * int
         */
//        s = s + 1;
    }

    @Test
    public void testShort1() {
        short s = 1;
        s += 1;
    }
}
