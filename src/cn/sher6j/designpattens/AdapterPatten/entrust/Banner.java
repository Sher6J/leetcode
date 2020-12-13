package cn.sher6j.designpattens.AdapterPatten.entrust;

/**
 * @author sher6j
 * @create 2020-10-29-15:27
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }


    /**
     * 加括号显示
     */
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    /**
     * 加星号显示
     */
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
