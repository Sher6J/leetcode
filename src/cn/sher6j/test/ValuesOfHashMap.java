package cn.sher6j.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-11-15-18:26
 */
public class ValuesOfHashMap {
    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();

        List<String> l1 = Arrays.asList("bat");
        List<String> l2 = Arrays.asList("nat", "nta");
        List<String> l3 = Arrays.asList("ate", "aet", "eat");

        map.put("abt", l1);
        map.put("ant", l2);
        map.put("aet", l3);

        System.out.println(map.values().toString());
    }
}
