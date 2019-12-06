package Week2;

import java.util.*;

public class Leetcode_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new LinkedList<>();
        list = groupAnagrams1(strs);
        for (List<String> lis: list) {
            System.out.println(Arrays.toString(lis.toArray()));
        }
    }

    /**
     * 哈希表记录
     * 执行用时 :12 ms, 在所有 java 提交中击败了96.95%的用户
     * 内存消耗 :41 MB, 在所有 java 提交中击败了99.21%的用户
     * @param strs
     * @return
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (map.containsKey(s)) {
                List<String> lis = map.get(s);
                lis.add(str);
                map.put(s,lis);
            }
            else {
                List<String> lis = new LinkedList<>();
                lis.add(str);
                map.put(s,lis);
            }
        }
//        List<List<String>> ans = new LinkedList<>();
//        for (List<String> li : map.values()) {
//            ans.add(li);
//        }
//        return ans;
//        题解一句话搞定。。。
        return new LinkedList(map.values());
    }

    /**
     * 题解按计数分类方法
     * 执行用时 :50 ms, 在所有 java 提交中击败了18.53%的用户
     * 内存消耗 :44.2 MB, 在所有 java 提交中击败了88.60%的用户
     * 好像挺慢的。。赶紧不应该
     */
    private static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count,0);
            for (char c : str.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
//                sb.append('#');
//                去掉后从50ms提升到了18ms
//                执行用时 :18 ms, 在所有 java 提交中击败了79.76%的用户
//                内存消耗 :41.3 MB, 在所有 java 提交中击败了98.98%的用户
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        return new LinkedList(ans.values());
    }
}
