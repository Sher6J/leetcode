//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 并查集 数组 
// 👍 106 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Java：交换字符串中的元素
public class P1202SmallestStringWithSwaps{
    public static void main(String[] args) {
        Solution solution = new P1202SmallestStringWithSwaps().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null || pairs.size() == 0) {
            return s;
        }

        int n = s.length();
        UnionFind uf = new UnionFind(n);
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(n);
        char[] chars = s.toCharArray();

        // 1.将任意交换的节点对输入并查集
        // 比如 (0, 1)、(1, 3)，则0,1,3三者均可交换，构成同一门派
        // 同一门派为进行排序为最小字典序，则整体即为最小字典序
        for(List<Integer> pair : pairs) {
            int idx1 = pair.get(0);
            int idx2 = pair.get(1);
            uf.union(idx1, idx2);
        }

        // 2.构建映射关系
        // k:连通分量的代表元(门派首脑)
        // v:当前门派的所有元素(由于需要按字典序排序，考虑用优先队列存储)
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            if (map.containsKey(root)) {
                map.get(root).offer(chars[i]);
            } else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(chars[i]);
                map.put(root, minHeap);
            }
        }

        // 3.重组字符串返回结果
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            res.append(map.get(root).poll());
        }
        return res.toString();
    }

    /**
     * 图的连通性问题，当只考虑是否连通，而不关心怎么连通时
     * 优先考虑并查集
     */
    private class UnionFind {
        private int[] parent;

        /**
         * 以 i 为根节点的子树高度（由于路径压缩，其含义和子树高度其实不同）
         * 准确理解的话，可以理解为当前门派的元素数
         */
        private int[] rank;

        /**
         * 初始化长度为 n 的并查集，
         * 每个元素其父亲都是自己，
         * 以当前为根节点的子树只有当前节点一个节点
         * @param n
         */
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * 合并两个元素的门派
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            // 门派相同不做处理
            if (rootX == rootY) {
                return;
            }

            // 门派不同更新门派，同时更新`[新]门派首脑`的rank
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }
        }

        /**
         * 查找元素 x 的门派
         * (边查边并——路径压缩)
         * @param x
         * @return
         */
        public int find(int x) {
            // 根节点的父亲是根节点自己
            // 若未查到根节点，则查的过程中合并门派
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}