package cn.sher6j.designpattens.PrototypePatten;

import cn.sher6j.designpattens.PrototypePatten.framework.Product;

/**
 * 将字符串加上下划线并显示的类
 * @author sher6j
 * @create 2020-10-30-19:15
 */
public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }
        System.out.println(" ");
    }

    @Override
    public Product createClone() {
        Product product = null;
        try {
            product = (Product)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
