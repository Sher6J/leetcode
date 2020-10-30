package cn.sher6j.designpattens.FactoryMethodPatten;

import cn.sher6j.designpattens.FactoryMethodPatten.framework.Factory;
import cn.sher6j.designpattens.FactoryMethodPatten.framework.Product;
import cn.sher6j.designpattens.FactoryMethodPatten.idcard.IDCardFactory;

/**
 * @author sher6j
 * @create 2020-10-30-16:11
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小利");
        card1.use();
        card2.use();
        card3.use();
    }
}
