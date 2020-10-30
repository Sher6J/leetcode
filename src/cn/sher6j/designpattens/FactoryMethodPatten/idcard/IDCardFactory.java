package cn.sher6j.designpattens.FactoryMethodPatten.idcard;

import cn.sher6j.designpattens.FactoryMethodPatten.framework.Factory;
import cn.sher6j.designpattens.FactoryMethodPatten.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-10-30-16:08
 */
public class IDCardFactory extends Factory {
    private List owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List getOwners() {
        return owners;
    }
}
