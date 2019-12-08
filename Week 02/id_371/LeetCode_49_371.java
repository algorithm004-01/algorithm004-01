import java.util.*;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-24 11:29
 **/

public class LeetCode_49_371 {
    public static void main(String[] args) {
        //["eat", "tea", "tan", "ate", "nat", "bat"], ==>[1,1,2,1,2,3]==>[[1,1,1],[2,2],[3]]
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        result.stream().forEach(System.out::println);

    }


    /**
     * 原解>优化(哈希表)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        //0.边界判断
        if (strs == null || strs.length == 0) return null;
        //1.将所有字符串放入 map 中,key 为字符数组,值为 List
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //2.将字符串排序后作为map的 key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
           /* if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }*/
            //将上面这段代码修改为下面一行,更加简洁
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        //一开始在这里多些了一次循环遍历,会造成效率变低
       /* List<List<String>> result = new ArrayList<>();
        map.forEach((key,value)->{
            result.add(value);
        });*/
        return new ArrayList<>(map.values());
    }
}
