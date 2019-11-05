import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode_49_576
 */
public class LeetCode_49_576 {
    //1.hashmap --> {string,list},string就是排序后的单词，list存放异位词
    /*
    时间复杂度：O(NKlogK)，其中 NN 是 strs 的长度，
    而 KK 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。
    然后，我们在 O(KlogK) 的时间内对每个字符串排序。
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();//这里为什么不用加<>?
        }
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());//这里为什么不用加<>?
    }
    
    //2. 当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。说实话没太看懂代码
    public List<List<String>> groupAnagtams2(String[] strs) {
        
    }
}
