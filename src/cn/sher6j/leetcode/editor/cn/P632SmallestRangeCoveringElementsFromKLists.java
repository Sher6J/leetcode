//你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。 
//
// 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。 
//
// 示例 1: 
//
// 
//输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//输出: [20,24]
//解释: 
//列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
//列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
//列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
// 
//
// 注意: 
//
// 
// 给定的列表可能包含重复元素，所以在这里升序表示 >= 。 
// 1 <= k <= 3500 
// -105 <= 元素的值 <= 105 
// 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。 
// 
// Related Topics 哈希表 双指针 字符串


package cn.sher6j.leetcode.editor.cn;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Java：最小区间
public class P632SmallestRangeCoveringElementsFromKLists{
    public static void main(String[] args) {
        Solution solution = new P632SmallestRangeCoveringElementsFromKLists().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int leftRange = 0, rightRange = Integer.MAX_VALUE;//所求区间的左、右边界
        int minRange = rightRange - leftRange;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] pos = new int[size]; //对size个列表维护size个指针，标志该列表目前遍历到的位置，每个列表起始指针都为0
        //最小堆使堆顶元素为包含size个指针指向的元素的最小值的那个列表的索引
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer list1, Integer list2) {
                // 第list1/2个列表其pos[list1/2]指向的元素为比较单位
                return nums.get(list1).get(pos[list1]) - nums.get(list2).get(pos[list2]);
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            heap.offer(i);//heap中存第i个列表
            max = Math.max(max, nums.get(i).get(0)); //初始最大值为所有列表第一个元素的最大值
        }
        while (true) {
            int minIndex = heap.poll(); //堆顶永远是具有当前最小值的那个列表
            int curRange = max - nums.get(minIndex).get(pos[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                leftRange = nums.get(minIndex).get(pos[minIndex]);
                rightRange = max;
            }
            pos[minIndex]++; //将取出最小值的对应列表指针前移，同时堆顶为新的具有最小值的列表索引
            if (pos[minIndex] == nums.get(minIndex).size()) { //若有一个列表走到头，则循环终止
                break;
            }
            heap.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(pos[minIndex]));
        }
        return new int[]{leftRange, rightRange};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}