package id_511;

import java.util.*;

/**
 * @version 1.0
 * @Description: 字母异位词分组
 * @author: bingyu
 * @date: 2019/10/30 21:23
 */
public class LeetCode_49_511 {


    //使用hash表，将排序后的字符串作为key，每一个key对应一个List。list里就是存放排序前的字符串即可
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);  //获得排序后的字符串
            if (!map.containsKey(key)) { //每一个排序的key对应一个List，list里存放原来的字符串
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }


    public static void main(String[] args) {
        String[] ar = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(ar);
        System.out.println(lists);
    }
}
