package cn.sher6j.jvm.rumtime;

/**
 * @author sher6j
 * @create 2020-11-28-17:45
 */
public class LocalVariable {

    public void reuse() {

        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        int c = a + 1;
    }
}
