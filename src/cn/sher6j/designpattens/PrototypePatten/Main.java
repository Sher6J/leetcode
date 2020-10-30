package cn.sher6j.designpattens.PrototypePatten;

import cn.sher6j.designpattens.PrototypePatten.framework.Manager;
import cn.sher6j.designpattens.PrototypePatten.framework.Product;

/**
 * @author sher6j
 * @create 2020-10-30-19:19
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        Product p1 = manager.create("strong message");
        p1.use("Sher6J");
        Product p2 = manager.create("warning box");
        p2.use("Sher6J");
        Product p3 = manager.create("slash box");
        p3.use("Sher6J");
        Product p4 = manager.create("slash box");
        System.out.println(p3 == p4);
    }
}
