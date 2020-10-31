package cn.sher6j.datastructure;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sher6j
 * @create 2020-10-31-16:50
 */
public class MyLinkedList<T> implements Iterable<T>{

    private int theSize;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, null, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 尾部添加值
     * @param x
     * @return
     */
    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    /**
     * 索引处添加值
     * @param idx
     * @param x
     */
    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    /**
     * 获取索引处值
     * @param idx
     * @return
     */
    public T get(int idx) {
        return getNode(idx).data;
    }

    /**
     * 索引处设置新值
     * @param idx
     * @param newVal
     * @return
     */
    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    /**
     * 删除索引处值
     * @param idx
     * @return
     */
    public T remove(int idx) {
        return remove(getNode(idx));
    }

    /**
     * 在 p 节点前添加节点 x
     * @param p
     * @param x
     */
    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    /**
     * 删除 p 节点
     * @param p
     * @return 被删除节点的值
     */
    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    /**
     * 获得索引处的节点
     * @param idx
     * @return
     */
    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;

        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }

        if (idx < (size() >> 1)) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }

        return p;
    }

    /**
     * 获取迭代器
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * 链表的节点
     * @param <T>
     */
    private static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> cur = beginMarker.next;
        private int expectModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return cur != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T nextItem = cur.data;
            cur = cur.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(cur.prev);
            expectModCount++;
            okToRemove = false;
        }
    }
}
