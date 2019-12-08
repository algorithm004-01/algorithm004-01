class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> resultMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charList = strs[i].toCharArray();
            Arrays.sort(charList);
            String temp = String.valueOf(charList);
            if (!resultMap.containsKey(temp)) {
                resultMap.put(temp, new ArrayList<>());
            }
            resultMap.get(temp).add(strs[i]);
        }
        result.addAll(resultMap.values());
        return result;
    }
}
