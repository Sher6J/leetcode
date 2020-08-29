//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 说明: 
//
// 
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排
//序更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 
//
// 示例 1: 
//
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2: 
//
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：重新安排行程
public class P332ReconstructItinerary{
    public static void main(String[] args) {
        Solution solution = new P332ReconstructItinerary().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) map.put(src, new PriorityQueue<>());
            map.get(src).offer(dst);
        }
        dfs("JFK", map, path);
        Collections.reverse(path);
        return path;
    }

    /**
     * 深度优先搜索
     * @param curr 当前地点
     * @param map ticket集合，用于判断当前地点可到达地点
     * @param path 路径，为最终结果的逆序
     */
    public void dfs(String curr, Map<String, PriorityQueue<String>> map, List<String> path) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String next = map.get(curr).poll();
            dfs(next, map, path);
        }
        path.add(curr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}