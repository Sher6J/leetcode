package cn.sher6j.designpattens.FactoryMethodPatten.idcard;

import cn.sher6j.designpattens.FactoryMethodPatten.framework.Product;

/**
 * @author sher6j
 * @create 2020-10-30-16:06
 */
public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
