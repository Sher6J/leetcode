package cn.sher6j.designpattens.PrototypePatten.framework;

/**
 * @author sher6j
 * @create 2020-10-30-19:02
 */
public interface Product extends Cloneable{
    void use(String s);
    Product createClone();
}
