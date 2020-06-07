//给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
//=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。 
//
// 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：["a==b","b!=a"]
//输出：false
//解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
// 
//
// 示例 2： 
//
// 输出：["b==a","a==b"]
//输入：true
//解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
// 
//
// 示例 3： 
//
// 输入：["a==b","b==c","a==c"]
//输出：true
// 
//
// 示例 4： 
//
// 输入：["a==b","b!=c","c==a"]
//输出：false
// 
//
// 示例 5： 
//
// 输入：["c==c","b==d","x!=z"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] 和 equations[i][3] 是小写字母 
// equations[i][1] 要么是 '='，要么是 '!' 
// equations[i][2] 是 '=' 
// 
// Related Topics 并查集 图


package cn.sher6j.leetcode.editor.cn;
//Java：等式方程的可满足性
public class P990SatisfiabilityOfEqualityEquations{
    public static void main(String[] args) {
        Solution solution = new P990SatisfiabilityOfEqualityEquations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        /*
        并查集：
         */
        int[] parent = new int[26];
        //记录26个字母的父节点，实现并查集，初始每个字母的父节点都为自己
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String s : equations) {
            //对于"=="两端的字母，在并查集中进行连通
            if (s.charAt(1) == '=') {
                int charNum1 = s.charAt(0) - 'a';
                int charNum2 = s.charAt(3) - 'a';
                union(parent, charNum1, charNum2);
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int charNum1 = s.charAt(0) - 'a';
                int charNum2 = s.charAt(3) - 'a';
                //若"!="两端的字母在并查集中连通，则返回false
                if (find(parent, charNum1) == find(parent, charNum2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 对并查集中元素进行连通，即加入同一帮派，认同一掌门即可
     * @param parent
     * @param charNum1
     * @param charNum2
     */
    public void union(int[] parent, int charNum1, int charNum2) {
        parent[find(parent, charNum1)] = find(parent, charNum2);
    }

    /**
     * 找到并查集中连通分量（即同一帮派）中的祖宗（即掌门人）
     * @param parent
     * @param charNum
     * @return
     */
    public int find(int[] parent, int charNum) {
        //没找到掌门人就向上重构进行路径压缩，最理想的路径压缩结果就是同一帮派的所有人都指向掌门人
        while (parent[charNum] != charNum) {
            parent[charNum] = parent[parent[charNum]];
            charNum = parent[charNum];
        }
        //当结束while循环时，charNum为掌门人
        return charNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}