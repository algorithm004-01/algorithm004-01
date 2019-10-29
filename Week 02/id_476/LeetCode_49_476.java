import java.util.*;

public class LeetCode_49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new LeetCode_49_GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }


    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null) return null;
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String newStr = Arrays.toString(chars);
                if (!map.containsKey(newStr)) {
                    map.put(newStr, new ArrayList<>());
                }
                map.get(newStr).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

}