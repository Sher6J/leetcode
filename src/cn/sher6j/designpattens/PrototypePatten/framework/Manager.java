package cn.sher6j.designpattens.PrototypePatten.framework;

import java.util.HashMap;

/**
 * @author sher6j
 * @create 2020-10-30-19:04
 */
public class Manager {
    private HashMap<String, Product> showcase = new HashMap();

    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String protoname) {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}
