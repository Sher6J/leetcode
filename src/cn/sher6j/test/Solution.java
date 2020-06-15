package cn.sher6j.test;

import java.util.*;

/**
 * @author sher6j
 * @create 2020-06-13-22:33
 */


class TreeAncestor {

    private int n; //节点个数
    private int[] nums; //节点值
    private int[] parent; //节点的父节点

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            this.nums[i] = i;
        }
    }

    public int getKthAncestor(int node, int k) {
        int index = getIndex(this.nums, node);
        if (index == -1) return -1;
        for (int j = 0; j < k; j++) {
            int p = this.parent[index];
            if (getIndex(this.nums, p) == -1) return -1;
            index = getIndex(nums, nums[getIndex(nums, p)]);
        }
        return nums[index];
    }

    public int getIndex (int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) return i;
        }
        return -1;
    }
}
