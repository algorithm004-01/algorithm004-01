Class solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (length(strs == 0 ) return new ArrayList[];
        Map<String,List> map = new HashMap<>();
        for (String str: strs) {
            char[] ans = str.toCharArray();
            Arrays.sort(ans);
            String ansKey = String.valueof(ans);
            if (! map.containsKey(ansKey) {
                map.put(ansKey,new ArrayList());
            }
            map.get(ansKey).add(str);
        }
        return new ArrayList(map.values());
    }
    
}

public List<List<String>> groupAnagram(String[] strs) {
    if(str.length() == 0) return new ArrayList();
    Map<String,List<String>> map = new HashMap<>();
    for(String s : strs) {
        int arr = new int[26]();
        for( int i = 0; i < s.length; i++){
            arr[s.charAt(i) - 'a']++;
        }
       String key = String.valueof(arr);
       List<String> tempList = map.getOrDefault(key,new ArrayList());
       tempList.add(s);
       map.put(key,tempList);
    }
    return new ArrayList(map.values());
}