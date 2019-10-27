class Solution {
    
    boolean[] used ;
    List<List<Integer>> resList = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        if(n == 0) return resList;
        Arrays.sort(nums);
        
        used = new boolean[n];
        findpermuteUnique(nums,0,new Stack<Integer>());
        return resList;
    }
    
    public void findpermuteUnique(int[] nums,int dept, Stack<Integer> path){
        if(dept == nums.length){
            resList.add(new ArrayList(path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                //复合剪枝操作
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                path.add(nums[i]);
                findpermuteUnique(nums,dept + 1,path);
                used[i] = false;
                path.pop();
            }
        }
    }
}