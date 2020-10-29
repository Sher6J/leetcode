package cn.sher6j.designpattens.AdapterPatten.extend;

/**
 * 类适配器模式——使用继承
 * @author sher6j
 * @create 2020-10-29-15:30
 */
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Sher6J");
        p.printWeek();
        p.printStrong();
    }
}
