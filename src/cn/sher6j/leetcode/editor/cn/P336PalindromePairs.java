//给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 
//
// 示例 1： 
//
// 输入：["abcd","dcba","lls","s","sssll"]
//输出：[[0,1],[1,0],[3,2],[2,4]] 
//解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2： 
//
// 输入：["bat","tab","cat"]
//输出：[[0,1],[1,0]] 
//解释：可拼接成的回文串为 ["battab","tabbat"] 
// Related Topics 字典树 哈希表 字符串


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：回文对
public class P336PalindromePairs{
    public static void main(String[] args) {
        Solution solution = new P336PalindromePairs().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //字典树节点
    class TrieNode {
        int[] next = new int[26];
        int flag;

        public TrieNode() {
            this.flag = -1;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        //字典树
        List<TrieNode> trie = new ArrayList<>();
        trie.add(new TrieNode());
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insertToTrie(words[i], i, trie);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            //此处必须为<=m，因为字符串s拆分可以为 s和空串，若是<m，则最后一个是拆分为s[0, s.len - 2]和s[s.len - 1]
            for (int j = 0; j <= m ; j++) {
                //s[j, m - 1]为回文串，则查看s剩下部分的反转是否存在于words中
                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = findWordInTrie(words[i], 0, j - 1, trie);
                    if (leftId != -1 && leftId != i) {
                        res.add(Arrays.asList(i, leftId));
                    }
                }
                //此处必须为 j!=0 ，否则会再次将字符串s拆分为s和空串，和上面出现重复结果
                //s[0, j - 1]为回文串，则查看s剩下部分的反转是否存在于words中
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWordInTrie(words[i], j, m - 1, trie);
                    if (rightId != -1 && rightId != i) {
                        res.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return res;
//        return stupidMethod(words);
    }

    /**
     * 向字典树中插入键（字符串）
     * @param s 字符串
     * @param id 字符串的id
     * @param trie 字典树
     */
    public void insertToTrie(String s, int id, List<TrieNode> trie) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            if (trie.get(add).next[idx] == 0) {
                trie.add(new TrieNode());
                trie.get(add).next[idx] = trie.size() - 1;
            }
            add = trie.get(add).next[idx];
        }
        trie.get(add).flag = id;
    }

    /**
     * 判断字符串的从 [left, right] 的子串是否为回文串
     * @param s 字符串
     * @param left 字符串子串起始位置
     * @param right 字符串子串终止位置
     * @return
     */
    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) return false;
        }
        return true;
    }

    /**
     * 查找字符串的给定[left, right]子串的反转是否在字典树中
     * @param s 字符串
     * @param left 字符串子串起始位置
     * @param right 字符串子串终止位置
     * @param trie 字典树
     * @return
     */
    public int findWordInTrie(String s, int left, int right, List<TrieNode> trie) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int idx = s.charAt(i) - 'a';
            if (trie.get(add).next[idx] == 0) return -1;
            add = trie.get(add).next[idx];
        }
        return trie.get(add).flag;
    }

    /**
     * 法一：暴力解法，通过了 114 / 134 个测试用例
     * 时间复杂度：O(n^2·m) 两层for循环，还有判断回文的时间复杂度，m为字符串平均长度
     * @param words
     * @return
     */
    public List<List<Integer>> stupidMethod(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == i) continue;
                if (isPalindrome(words[i] + words[j])) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    /**
     * 判断字符串是否为回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int front = 0;
        int back = s.length() - 1;
        while (front < back) {
            while (front < back && !Character.isLetterOrDigit(s.charAt(front))) front++;
            while (front < back && !Character.isLetterOrDigit(s.charAt(back))) back--;
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(back))) return false;
            front++;
            back--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}