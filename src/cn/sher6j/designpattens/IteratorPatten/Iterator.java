package cn.sher6j.designpattens.IteratorPatten;

/**
 * @author sher6j
 * @create 2020-10-29-15:05
 */
public interface Iterator {
    /**
     * 判断是否存在下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素，并将迭代器移动下一个元素
     * @return
     */
    Object next();
}
