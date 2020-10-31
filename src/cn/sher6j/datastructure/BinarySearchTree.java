package cn.sher6j.datastructure;

import java.util.NoSuchElementException;

/**
 * 二叉查找树
 * @author sher6j
 * @create 2020-10-31-19:12
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root; // 二叉搜索书唯一属性——根节点

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty Tree!");
        } else {
            printTree(root);
        }
    }

    /**
     * 判断树 t 中是否存在节点 x
     * @param x
     * @param t
     * @return
     */
    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null) {
            return false;
        }

        int cmp = x.compareTo(t.element);

        if (cmp < 0) {
            return contains(x, t.left);
        } else if (cmp > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    /**
     * 返回 t 树中的最小值节点
     * @param t
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t != null) {
            while (t.left != null) {
                t = t.left;
            }
        }
        return t;
    }

    /**
     * 返回 t 树中的最大值节点
     * @param t
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    /**
     * 插入节点
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }

        int cmp = x.compareTo(t.element);

        if (cmp < 0) {
            t.left = insert(x, t.left);
        } else if (cmp > 0) {
            t.right = insert(x, t.right);
        } else {
            // 重复值什么也不做
        }

        return t;
    }

    /**
     * 删除节点
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null) {
            return t;
        }

        int cmp = x.compareTo(t.element);

        if (cmp < 0) {
            t.left = remove(x, t.left);
        } else if (cmp > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    /**
     * 中序打印二叉树
     * @param t
     */
    private void printTree(BinaryNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * 二叉树节点类
     * @param <T>
     */
    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T e) {
            this(e, null, null);
        }

        public BinaryNode(T e, BinaryNode<T> l, BinaryNode<T> r) {
            element = e;
            left = l;
            right = r;
        }
    }
}
