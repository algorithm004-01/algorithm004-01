import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-22 19:30
 **/

public class LeetCode_242_371 {
    public static void main(String[] args) {
        String s = "anagram";
//        String s = "car";
        String t = "nagaram";
//        String t = "rat";
        System.out.println(isAnagram3(s, t));

    }

    /**
     * 散列表(基于数组),26个字母字符-->转化成数组的索引
     *
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        //0.处理边界值
        if (sLen != tLen) {
            return false;
        }
        int[] alphaArr = new int[26];
        //1.将字符串s转化为数组,统计每个字母字符出现的次数(数组索引-->字母字符,索引元素-->字符出现的次数)
        for (int i = 0; i < sLen; i++) {
            alphaArr[s.charAt(i) - 'a']++;
        }
        //2.将字符串t转化为数组
        for (int q = 0; q < tLen; q++) {
            alphaArr[t.charAt(q)-'a']--;
            //3.统计并消除字符串 t 中字母出现的次数,如果索引元素小于零,说明两个额字符串不相等
            if (alphaArr[t.charAt(q)-'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 原解2:排序
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        //1.将字符串转化为字符数组
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        //2.对字符数组进行排序
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        //3.比较字符串是否先等
        return Arrays.equals(charsS, charsT);
    }

    /**
     * 原解1:将题目--->转换成是否存在问题--->map
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        //1.用 map作为容器记录字母和s 中字母出现的频次 ,和t比较
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < sLen; i++) {
            Integer key = Integer.valueOf(s.charAt(i));
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        for (int i = 0; i < tLen; i++) {
            Integer key = Integer.valueOf(t.charAt(i));
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                if (value == 1) {
                    map.remove(key);
                } else {
                    map.put(key, --value);
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
