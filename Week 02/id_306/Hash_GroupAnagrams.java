import java.util.*;

/**
 * Created by LynnSun on 2019/10/23.
 */
public class Hash_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    /**
     * 提交结果：
     执行用时 :11 ms, 在所有 Java 提交中击败了99.34% 的用户
     内存消耗 :42.1 MB, 在所有 Java 提交中击败了97.40%的用户

     思路：字母异位词，相同的字母具有相同的数量，我选择把字符串转换成字符数组（方便操作），
     进行一个排序，再转换为字符串。我使用一个map来记录某一种字母异位词是否已经出现，若已经出现，
     它对应的值就是他这个字母异位词在返回集合中的索引，找到并将其加入。若不存在，则新建键值对和一个List《String》。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res =new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        int count=0;//记录总共有多少个字母异位词
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s))res.get(map.get(s)).add(str);
            else {
                map.put(s.toString(),count++);
                List tmp=new ArrayList();
                tmp.add(str);
                res.add(tmp);
            }
        }
        return res;
    }
}
