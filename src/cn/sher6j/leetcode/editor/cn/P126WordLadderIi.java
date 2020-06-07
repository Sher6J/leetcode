//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：单词接龙 II
public class P126WordLadderIi{
    public static void main(String[] args) {
        Solution solution = new P126WordLadderIi().new Solution();
        // TO TEST
        String begingWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> ladders = solution.findLadders(begingWord, endWord, wordList);
        System.out.println(ladders);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    法一：遍历 wordList 来判断每个单词和当前单词是否只有一个字母不同
        普通用例可通过，但是超时
     */
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        List<String> temp = new ArrayList<>();
//        //temp 用来保存当前的路径
//        temp.add(beginWord);
//        findLaddersHelper(beginWord, endWord, wordList, temp, ans);
//        return ans;
//    }
//
//    int min = Integer.MAX_VALUE;
//
//    private void findLaddersHelper(String beginWord, String endWord, List<String> wordList,
//                                   List<String> temp, List<List<String>> ans) {
//        if (beginWord.equals(endWord)) {
//            if (min > temp.size()) {
//                ans.clear();
//                min = temp.size();
//                ans.add(new ArrayList<>(temp));
//            } else if (min == temp.size()) {
//                ans.add(new ArrayList<>(temp));
//            }
//            return;
//        }
//        //当前的长度到达了 min，还是没有到达结束单词就提前结束
//        if (temp.size() >= min) {
//            return;
//        }
//        //遍历当前所有的单词
//        for (int i = 0; i < wordList.size(); i++) {
//            String curWord = wordList.get(i);
//            //路径中已经含有当前单词，如果再把当前单词加到路径，那肯定会使得路径更长，所以跳过
//            if (temp.contains(curWord)) {
//                continue;
//            }
//            //符合只有一个单词不同，就进入递归
//            if (oneChanged(beginWord, curWord)) {
//                temp.add(curWord);
//                findLaddersHelper(curWord, endWord, wordList, temp, ans);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//    private boolean oneChanged(String beginWord, String curWord) {
//        int count = 0;
//        for (int i = 0; i < beginWord.length(); i++) {
//            if (beginWord.charAt(i) != curWord.charAt(i)) {
//                count++;
//            }
//            if (count == 2) {
//                return false;
//            }
//        }
//        return count == 1;
//    }



    /*
    法二：将要找的节点单词的每个位置换一个字符，然后看更改后的单词在不在 wordList 中
        普通用例可通过，但是依旧超时
     */
//    int min = Integer.MAX_VALUE;
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        List<String> temp = new ArrayList<>();
//        temp.add(beginWord);
//        //temp 用来保存当前的路径
//        findLaddersHelper(beginWord, endWord, wordList, temp, ans);
//        return ans;
//    }
//
//
//    private void findLaddersHelper(String beginWord, String endWord, List<String> wordList,
//                                   List<String> temp, List<List<String>> ans) {
//        if (beginWord.equals(endWord)) {
//            if (min > temp.size()) {
//                ans.clear();
//                min = temp.size();
//                ans.add(new ArrayList<>(temp));
//            } else if (min == temp.size()) {
//                ans.add(new ArrayList<>(temp));
//            }
//            return;
//        }
//
//        if (temp.size() >= min) {
//            return;
//        }
//        Set<String> dict = new HashSet<>(wordList);
//        //一次性到达所有的下一个的节点
//        List<String> neighbors = getNeighbors(beginWord, dict);
//        for (String neighbor : neighbors) {
//            if (temp.contains(neighbor)) {
//                continue;
//            }
//            temp.add(neighbor);
//            findLaddersHelper(neighbor, endWord, wordList,  temp, ans);
//            temp.remove(temp.size() - 1);
//        }
//    }
//
//
//    private List<String> getNeighbors(String node, Set<String> dict) {
//        List<String> res = new ArrayList<>();
//        char chs[] = node.toCharArray();
//
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch)
//                    continue;
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                    res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//
//        }
//        return res;
//    }

    /*
    法三：通过广度优先搜索先确定最短路径的长度，然后深度优先搜索时超过该长度的搜索即无需考虑
        由于法一法二都超时，所以考虑考虑如何减少搜索，即可以先通过BFS确定最短路径长度
        普通用例可通过，但是还是超时
     */
//    int min = 0;
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        //如果不含有结束单词，直接结束，不然后边会造成死循环
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//        //利用 BFS 得到所有的邻居节点
//        Map<String, List<String>> map = bfs(beginWord, endWord, wordList);
//        List<String> temp = new ArrayList<>();
//        // temp 用来保存当前的路径
//        temp.add(beginWord);
//        findLaddersHelper(beginWord, endWord, map, temp, ans);
//        return ans;
//    }
//
//    private void findLaddersHelper(String beginWord, String endWord, Map<String, List<String>> map,
//                                   List<String> temp, List<List<String>> ans) {
//        if (beginWord.equals(endWord)) {
//            ans.add(new ArrayList<>(temp));
//
//            return;
//        }
//        if(temp.size() - 1==  min){
//            return;
//        }
//        // 得到所有的下一个的节点
//        List<String> neighbors = map.getOrDefault(beginWord, new ArrayList<>());
//        for (String neighbor : neighbors) {
//            if (temp.contains(neighbor)) {
//                continue;
//            }
//            temp.add(neighbor);
//            findLaddersHelper(neighbor, endWord, map, temp, ans);
//            temp.remove(temp.size() - 1);
//        }
//    }
//
//    public Map<String, List<String>> bfs(String beginWord, String endWord, List<String> wordList) {
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        Map<String, List<String>> map = new HashMap<>();
//        boolean isFound = false;
//
//        Set<String> dict = new HashSet<>(wordList);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            min++;
//            for (int j = 0; j < size; j++) {
//                String temp = queue.poll();
//                // 一次性得到所有的下一个的节点
//                List<String> neighbors = getNeighbors(temp, dict);
//                map.put(temp, neighbors);
//                for (String neighbor : neighbors) {
//                    if (neighbor.equals(endWord)) {
//                        isFound = true;
//                    }
//                    queue.offer(neighbor);
//                }
//            }
//            if (isFound) {
//                break;
//            }
//        }
//        return map;
//    }
//    private List<String> getNeighbors(String node, Set<String> dict) {
//        List<String> res = new ArrayList<>();
//        char chs[] = node.toCharArray();
//
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch)
//                    continue;
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                    res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//
//        }
//        return res;
//    }


    /*
    法四：虽然法三确定了最短路径，但是在深度搜索中还是搜索了大量节点，
        比如第 3 层中有第 2 层的相同节点，那第 2 层的这个节点就完全可以不进行搜索
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return ans;
        }
        // 利用 BFS 得到所有的邻居节点,以及每个节点的所在层数
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map, distance);
        List<String> temp = new ArrayList<>();
        // temp 用来保存当前的路径
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, distance, temp, ans);
        return ans;
    }

    private void findLaddersHelper(String beginWord, String endWord, Map<String, List<String>> map,
                                   Map<String, Integer> distance, List<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        // 得到所有的下一个的节点
        /*
        "a"
        "c"
        ["a","b","c"]*/
        //之所以是 map.getOrDefault 而不是 get，就是上边的情况 get 会出错
        List<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
        for (String neighbor : neighbors) {
            //判断层数是否符合
            if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
                temp.add(neighbor);
                findLaddersHelper(neighbor, endWord, map, distance, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> map,
                    Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean isFound = false;
        int depth = 0;
        Set<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                // 一次性得到所有的下一个的节点
                List<String> neighbors = getNeighbors(temp, dict);
                map.put(temp, neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, depth);
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                    }

                }
            }
            if (isFound) {
                break;
            }
        }
    }

    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}