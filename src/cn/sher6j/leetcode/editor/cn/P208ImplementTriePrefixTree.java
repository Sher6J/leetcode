//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树


package cn.sher6j.leetcode.editor.cn;

import sun.util.resources.cldr.ln.LocaleNames_ln;

//Java：实现 Trie (前缀树)
public class P208ImplementTriePrefixTree{
    public static void main(String[] args) {
//        Solution solution = new P208ImplementTriePrefixTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private boolean isEnd;
    private Trie[] next;
    private final int R = 26;

    /** Initialize your data structure here. */
    public Trie() {
        this.next = new Trie[R];
        this.isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (node.next[currChar - 'a'] == null) {
                node.next[currChar - 'a'] = new Trie();
            }
            node = node.next[currChar - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (node.next[currChar - 'a'] == null) {
                return false;
            }
            node = node.next[currChar - 'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (node.next[currChar - 'a'] == null) {
                return false;
            }
            node = node.next[currChar - 'a'];
        }
        return true;
    }

//    public TrieNode searchPrefix(String word) {
//        TrieNode node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char currChar = word.charAt(i);
//            if (node.containsKey(currChar)) {
//                node = node.get(currChar);
//            } else {
//                return null;
//            }
//        }
//        return node;
//    }
}

class TrieNode {
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}