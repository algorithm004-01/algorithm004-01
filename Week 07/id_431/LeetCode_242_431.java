package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class ValidAnagram {

//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        if (s.equals(t)) return true;
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            String v1 = s.substring(i, i + 1);
//            String v2 = t.substring(i, i + 1);
//            if (map.containsKey(v1)) {
//                map.put(v1, map.get(v1) + 1);
//            } else {
//                map.put(v1, 1);
//            }
//            if (map.containsKey(v2)) {
//                map.put(v2, map.get(v2) - 1);
//            } else {
//                map.put(v2, -1);
//            }
//        }
//        for (Integer val : map.values()) {
//            if (val != 0) return false;
//        }
//        return true;
//    }

//    public boolean isAnagram(String s, String t) {
//        if (s.equals(t)) return true;
//        //使用HashMap
//        Map<Character, Integer> map = new HashMap<>();
//        char[] sArray = s.toCharArray();
//        char[] tArray = t.toCharArray();
//        for (int i = 0; i < sArray.length; i++) {
//            if (!map.containsKey(sArray[i])){
//                map.put(sArray[i], 0);
//            }
//            map.put(sArray[i], map.get(sArray[i]) + 1);
//        }
//        for (int i = 0; i < tArray.length; i++) {
//            if (!map.containsKey(tArray[i])) return false;
//            map.put(tArray[i], map.get(tArray[i]) - 1);
//            if (map.get(tArray[i]) == 0) {
//                map.remove(tArray[i]);
//            }
//        }
//        return map.isEmpty();
//    }

//    public boolean isAnagram(String s, String t) {
//        if (s.equals(t)) return true;
//        if (s.length() != t.length()) return false;
//        char[] sArray = s.toCharArray();
//        char[] tArray = t.toCharArray();
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//        for(int i = 0; i < sArray.length; i++) {
//            if (sArray[i] != tArray[i]) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * 精彩代码
     * @param s
     * @param t
     * @return
     */
//    public boolean isAnagram(String s, String t) {
//        int[] alphabet = new int[26];
//        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
//        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
//        for (int i : alphabet) if (i != 0) return false;
//        return true;
//    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != tc[i]) return false;
        }
        return true;
    }
}
