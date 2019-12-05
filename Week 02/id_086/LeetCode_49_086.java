// 输出字符串数组中字母相同排序不同的集合 ，实现方法，利用 HashMap 中 containsKey 方法实现，
// 1、先通过便利把字符串数组中的字符按顺序排序（相同的字符经过排序之后会重复出现）
// 2、把不重复的字符添加到 HashMap 的 key 中（key的唯一性）
// 3、把包含的添加到符合的 key 的数组中

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> maps = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!maps.containsKey(key)) {
                maps.put(key, new ArrayList());
            }
            maps.get(key).add(s);
        }
        return new ArrayList(maps.values());
    }
}

