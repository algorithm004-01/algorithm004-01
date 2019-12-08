class Solution {
  
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(results, new StringBuilder(), 0, 0, n);
        return results;
    }
    
    public void dfs(List<String> results, StringBuilder result, int left, int right, int n){
        //terminator
        if (left == n && right == n){
            results.add(result.toString());
            return;
        }
        //process
        if (left < n){
            //drill down
            dfs(results, result.append("("), left+1, right, n);
            //reverse state
            result.deleteCharAt(result.length()-1);
        }
        
        if (right < n && right < left){
            //drill down
            dfs(results, result.append(")"), left, right+1, n);
            //reverse state
            result.deleteCharAt(result.length()-1);
        }
        
    }
}