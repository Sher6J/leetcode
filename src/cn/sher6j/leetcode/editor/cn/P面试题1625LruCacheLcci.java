//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 45 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：LRU缓存
public class P面试题1625LruCacheLcci{
    public static void main(String[] args) {
//        Solution solution = new P面试题 16.25LruCacheLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    // k - v : key - (key, value)
    private Map<Integer, Node> map;

    // (key, value) <-> (key, value)
    private DoubleList list;

    // capacity of the cache
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.list = new DoubleList();
        this.capacity = capacity;
    }


    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int val = node.value;
        // call `put` to move up the node visited recently
        this.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (this.map.containsKey(key)) {
            Node oldNode = this.map.get(key);
            this.list.removeNode(oldNode);
            // reinsert the node to the head
            // update the data of map
        } else {
            // cache full
            if (this.list.size() == capacity) {
                Node last = this.list.removeLast();
                this.map.remove(last.key);
                // insert the node to the head
                // update the data of map
            }
        }
        this.list.addFirst(newNode);
        this.map.put(key, newNode);
    }
}

/**
 * double linked list
 */
class DoubleList {
    Node head;
    Node tail;
    int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    /**
     * add node to the head of list
     * @param newNode the node to add
     */
    public void addFirst(Node newNode) {
        newNode.next = this.head.next;
        newNode.prev = this.head;
        this.head.next.prev = newNode;
        this.head.next = newNode;
        this.size++;
    }

    /**
     * remove node in the list
     * @param node the node to remove
     */
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.size--;
    }

    /**
     * remove the last node in the list
     * @return the removed node
     */
    public Node removeLast() {
        if (this.tail.next == this.head) {
            return null;
        }
        Node last = this.tail.prev;
        removeNode(last);
        return last;
    }

    public int size() {
        return this.size;
    }
}

/**
 * the node of DoubleLinkedList
 */
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int k, int v) {
        this.key = k;
        this.value = v;
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