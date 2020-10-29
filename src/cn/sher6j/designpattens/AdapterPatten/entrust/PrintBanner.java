package cn.sher6j.designpattens.AdapterPatten.entrust;

/**
 * @author sher6j
 * @create 2020-10-29-15:36
 */
public class PrintBanner extends Print{
    private Banner banner;

    @Override
    public void printWeek() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
