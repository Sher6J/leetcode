package cn.sher6j.designpattens.TemplateMethodPatten;

/**
 * @author sher6j
 * @create 2020-10-30-15:42
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
