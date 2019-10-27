/**
 * 字母异位词分组
 */
public class Solution {
    /**
     * 基于计算出现次数
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String ss = Arrays.toString(arr);
            if (!map.containsKey(ss)) map.put(ss, new ArrayList<>());
            map.get(ss).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 基于字符串排序
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sort = String.valueOf(arr);
            if (!map.containsKey(sort)) map.put(sort, new ArrayList<>());
            map.get(sort).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
