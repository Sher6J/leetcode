//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 119 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：查找常用字符
public class P1002FindCommonCharacters{
    public static void main(String[] args) {
        Solution solution = new P1002FindCommonCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] A) {
        int[] minCount = new int[26]; // 每个字符在所有数组中的最小出现次数
        Arrays.fill(minCount, Integer.MAX_VALUE);
        int[] curCount = new int[26]; // 每个字符在当前数组中的出现次数
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(curCount, 0);
            String cur = A[i];
            for (int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                curCount[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                minCount[j] = Math.min(minCount[j], curCount[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minCount[i]; j++) {
                res.add(String.valueOf((char)(i + 'a')));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}