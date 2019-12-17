class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if(map.containsKey(key) == false){
                //System.out.print(key + " ");
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        
        for (List value:map.values()){
            result.add(value);
        }
        
        return result;
    }
}