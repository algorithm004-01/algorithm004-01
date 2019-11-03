package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
              List<String> list = new ArrayList<>();
              list.add(strs[i]);
              map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }
}
