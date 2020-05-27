package cn.sher6j.leetcode.editor.cn;

import java.util.List;

/**
 * 树的节点
 * @author sher6j
 * @create 2020-05-27-20:08
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
