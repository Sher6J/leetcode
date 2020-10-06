//给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。 
//
// 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。 
//
// 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。 
//
// 示例 1: 
//
// 
//输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//输出: [8,12,6,10,10,10]
//解释: 
//如下为给定的树的示意图：
//  0
// / \
//1   2
//   /|\
//  3 4 5
//
//我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
//也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
// 
//
// 说明: 1 <= N <= 10000 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：树中距离之和
public class P834SumOfDistancesInTree{
    public static void main(String[] args) {
        Solution solution = new P834SumOfDistancesInTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> graph = new ArrayList<>(); // 邻接表
    int[] distSum; // 距离和
    int[] nodeNum; // 节点数
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        this.distSum = new int[N];
        this.nodeNum = new int[N];
        Arrays.fill(nodeNum, 1);
        postOrder(0, -1);
        preOrder(0, -1);
        return distSum;
    }

    /**
     * 从root到子树的所有节点距离和
     * @param root
     * @param parent
     */
    public void postOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for (int n : neighbors) {
            if (n == parent) continue;
            postOrder(n, root);
            nodeNum[root] += nodeNum[n];
            distSum[root] += distSum[n] + nodeNum[n];
        }
    }

    /**
     * 根据root计算其邻居到所在子树之外的节点的距离和（包括root节点）
     * @param root
     * @param parent
     */
    public void preOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for (int n : neighbors) {
            if (n == parent) continue;
            distSum[n] = distSum[root] - 2 * nodeNum[n] + graph.size();
            preOrder(n, root);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}