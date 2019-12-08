package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String v1 = s.substring(i, i + 1);
            String v2 = t.substring(i, i + 1);
            if (map.containsKey(v1)) {
                map.put(v1, map.get(v1) + 1);
            } else {
                map.put(v1, 1);
            }
            if (map.containsKey(v2)) {
                map.put(v2, map.get(v2) - 1);
            } else {
                map.put(v2, -1);
            }
        }
        for (Integer val : map.values()) {
            if (val != 0) return false;
        }
        return true;
    }
}
