//设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。 
//
// 注意: 允许出现重复元素。 
//
// 
// insert(val)：向集合中插入元素 val。 
// remove(val)：当 val 存在时，从集合中移除一个 val。 
// getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。 
// 
//
// 示例: 
//
// // 初始化一个空的集合。
//RandomizedCollection collection = new RandomizedCollection();
//
//// 向集合中插入 1 。返回 true 表示集合不包含 1 。
//collection.insert(1);
//
//// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//collection.insert(1);
//
//// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//collection.insert(2);
//
//// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//collection.getRandom();
//
//// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//collection.remove(1);
//
//// getRandom 应有相同概率返回 1 和 2 。
//collection.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 103 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：O(1) 时间插入、删除和获取随机元素 - 允许重复
public class P381InsertDeleteGetrandomO1DuplicatesAllowed{
    public static void main(String[] args) {
//        Solution solution = new P381InsertDeleteGetrandomO1DuplicatesAllowed().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> idxs;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        idxs = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> idx = this.idxs.getOrDefault(val, new HashSet<>());
        idx.add(list.size() - 1);
        idxs.put(val, idx);
        return idx.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idxs.containsKey(val)) {
            return false;
        }
        Iterator<Integer> iterator = idxs.get(val).iterator();
        int i = iterator.next();
        int last = list.get(list.size() - 1);
        list.set(i, last);
        idxs.get(val).remove(i);
        idxs.get(last).remove(list.size() - 1);
        if (i < list.size() - 1) {
            idxs.get(last).add(i);
        }
        if (idxs.get(val).size() == 0) {
            idxs.remove(val);
        }
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}