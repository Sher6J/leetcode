package cn.sher6j.designpattens.IteratorPatten;

/**
 * @author sher6j
 * @create 2020-10-29-15:05
 */
public interface Aggregate {
    /**
     * 生成一个用于遍历集合的迭代器
     * @return
     */
    Iterator iterator();
}
