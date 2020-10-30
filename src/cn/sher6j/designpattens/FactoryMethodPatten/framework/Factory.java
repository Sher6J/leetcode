package cn.sher6j.designpattens.FactoryMethodPatten.framework;

/**
 * @author sher6j
 * @create 2020-10-30-16:02
 */
public abstract class Factory {
    /**
     * 工厂方法生成实例
     * @param owner
     * @return
     */
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
