//编写一个 SQL 查询，查找所有至少连续出现三次的数字。 
//
// +----+-----+
//| Id | Num |
//+----+-----+
//| 1  |  1  |
//| 2  |  1  |
//| 3  |  1  |
//| 4  |  2  |
//| 5  |  1  |
//| 6  |  2  |
//| 7  |  2  |
//+----+-----+
// 
//
// 例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。 
//
// +-----------------+
//| ConsecutiveNums |
//+-----------------+
//| 1               |
//+-----------------+
// 
// 👍 351 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：连续出现的数字
public class P180ConsecutiveNumbers{
    public static void main(String[] args) {
//        Solution solution = new P180ConsecutiveNumbers().new Solution();
        // TO TEST
    }
    //There is no code of Java type for this problem
}

// SELECT DISTINCT l1.Num AS ConsecutiveNums
// FROM Logs l1, Logs l2, Logs l3
// WHERE l1.Id = l2.Id - 1
//   AND l2.Id = l3.Id - 1
//   AND l1.Num = l2.Num
//   AND l2.Num = l3.Num