package cn.sher6j;

/**
 * @author sher6j
 * @create 2020-12-22-11:10
 */
import java.util.HashMap;
public class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            addHead(n);
            return n.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            addHead(n);
        } else {
            Node p = new Node(key, value);
            addHead(p);
            map.put(key, p);
        }
        if (map.size() >= this.capacity) {
            map.remove(end.key);
            remove(end);
        }
    }
    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }
    public void addHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }
    @Override
    public String toString() {
        return "LRUCache [capacity=" + capacity + ", map=" + map + ", head="
                + head + ", end=" + end + "]";
    }
}