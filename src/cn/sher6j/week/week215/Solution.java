package cn.sher6j.week.week215;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author sher6j
 * @create 2020-11-15-10:29
 */
public class Solution {

    public boolean closeStrings(String word1, String word2) {
        return false;
    }

    public int minOperations(int[] nums, int x) {
        return 0;
    }
}

/**
 *
 */
class OrderedStream {

    private Map<Integer, String> flow;
    private int ptr;

    public OrderedStream(int n) {
        this.flow = new HashMap(n);
        this.ptr = 1;
    }

    public List<String> insert(int id, String value) {
        List<String> list = new LinkedList<>();
        flow.put(id, value);
        if (id == ptr) {
            while (flow.containsKey(ptr)) {
                list.add(flow.get(ptr));
                ptr++;
            }
        }
        return list;
    }
}
