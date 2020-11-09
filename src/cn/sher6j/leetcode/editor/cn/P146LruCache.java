//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;

//Java：LRU缓存机制
public class P146LruCache{
    public static void main(String[] args) {
//        Solution solution = new P146LruCache().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private HashMap<Integer, Node> map; //key - Node(key, val)
    private DoubleList cache; //(k1, v1) <-> (k2, v2)
    private int capacity; //最大容量

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) return -1;
        int val = this.map.get(key).val;
        this.put(key, val); //用put方法将刚访问的数据提前
        return val;
    }
    
    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (this.map.containsKey(key)) {
            //删除旧的节点，然后将替代的新节点插入到头部
            this.cache.removeNode(this.map.get(key));
            //更新map中的数据
        } else {
            if (this.capacity == this.cache.size()) { //容量已满
                Node last = this.cache.removeLast();
                this.map.remove(last.key);
            }
            //添加到头部
        }
        this.cache.addFirst(x);
        this.map.put(key, x);
    }
}

/**
 * 双向链表
 */
class DoubleList {
    private Node head, tail; //头、尾虚节点
    private int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    /**
     * 在双向链表头部添加节点
     * @param x 要添加的节点
     */
    public void addFirst(Node x) {
        x.next = this.head.next;
        x.prev = this.head;
        this.head.next.prev = x;
        this.head.next = x;
        this.size++;
    }

    /**
     * 删除节点x
     * @param x 要删除的节点
     */
    public void removeNode(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        this.size--;
    }

    /**
     * 删除链表中最后一个节点
     * @return 删除的节点
     */
    public Node removeLast() {
        if (this.tail.prev == this.head) return null;
        Node lastNode = this.tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    /**
     * 链表长度
     * @return 链表长度
     */
    public int size() {
        return this.size;
    }
}

/**
 * 双向链表的节点
 */
class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}