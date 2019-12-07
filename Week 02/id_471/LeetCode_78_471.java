class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        dfs(0, nums, new ArrayList<>(), results);
        return results;
    }
    
    public void dfs(int cur, int[] nums, List<Integer> result, List<List<Integer>> results){
        //terminator
        if (cur == nums.length){ 
            return;
        }
        //process
        for (int i = cur; i < nums.length; i++){
            result.add(nums[i]);
            results.add(new ArrayList<>(result));
            //drill down
            dfs(i+1, nums, result, results);
            //reverse state
            result.remove(result.size() - 1);
        }
    }
}