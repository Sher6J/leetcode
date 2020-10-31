package cn.sher6j.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sher6j
 * @create 2020-10-31-16:15
 */
public class MyArrayList <T> implements Iterable<T>{
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 将实际存储数组空间缩减到最小状态
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 获取数组元素
     * @param idx 索引
     * @return
     */
    public T get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    /**
     * 在索引处设置新值
     * @param idx
     * @param newVal
     * @return oldVal
     */
    public T set(int idx, T newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    /**
     * 确保容量
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    /**
     * 在末尾添加元素
     * @param x
     * @return
     */
    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    /**
     * 在索引处添加元素
     * @param idx
     * @param x
     */
    public void add(int idx, T x) {
        if (theItems.length == size()) {
            ensureCapacity(size() << 1 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    /**
     * 删除索引处元素
     * @param idx
     * @return
     */
    public T remove(int idx) {
        T removedItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }

    /**
     * 返回一个迭代器
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * 内部迭代器类
     */
    private class ArrayListIterator implements Iterator<T> {
        private int cur = 0;

        @Override
        public boolean hasNext() {
            return cur < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[cur++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--cur);
        }
    }

    public T[] toArray() {
        return theItems;
    }
}
