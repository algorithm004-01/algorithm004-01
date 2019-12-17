class Solution {
    
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        
        if ( n <= 0 || k <= 0 || n < k){
            return res;
        }
        
        helper(n, k, 1, new Stack<Integer>());
        return res;
    }
    
    


    private void helper(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }
        
        for (int i = begin; i <= n; i++) {
            pre.add(i);
            helper(n, k, i + 1, pre);
            pre.pop();
        }
    }


}