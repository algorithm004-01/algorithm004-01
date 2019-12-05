// 遍历strs数组，把每个str.toCharArr后排序，将排序后的sortedStr作为key放入map，value为List<String>，最后取出map.values()
public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> hash = new HashMap<>();
    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = String.valueOf(chars);
        // 常见写法
        if (hash.get(key) == null){
            hash.put(key, new ArrayList<>());
        }
        hash.get(key).add(str);
    }
    List<List<String>> ret = new ArrayList<>();
    ret.addAll(hash.values());
    return ret;
}