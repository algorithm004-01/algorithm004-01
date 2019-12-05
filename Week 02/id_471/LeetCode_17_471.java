class Solution {
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits) || null == digits){
            return new ArrayList<>();
        }
        List<String> results = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(0, "", results, map, digits);
        return results;
    }
    
    public void dfs(int cur, String result, List<String> results, Map<Character, String> map, String digits){
        //terminator
        if (cur == digits.length()){
            results.add(result);
            return;
        }
        
        //process data
        String word = map.get(digits.charAt(cur));
        for (int i = 0; i < word.length(); i++){
            //drill down
            dfs(cur+1, result+word.charAt(i), results, map, digits);
        }
    }
}