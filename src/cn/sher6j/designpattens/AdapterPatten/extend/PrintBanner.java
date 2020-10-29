package cn.sher6j.designpattens.AdapterPatten.extend;

/**
 * @author sher6j
 * @create 2020-10-29-15:29
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeek() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
