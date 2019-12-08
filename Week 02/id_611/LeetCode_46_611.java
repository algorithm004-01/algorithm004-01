class Solution {
    //回溯+剪枝+状态重置
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> resList = new ArrayList();
        if(len == 0){
            return resList;
        }
       
        //状态记忆
        boolean[] used = new boolean[nums.length+1];
        //路径记忆
        Stack<Integer> path = new Stack();
        
        geneatePermute( nums, resList, 0, len, used, path);
        return resList;
    }
    
    
    public void geneatePermute(int[] nums,List<List<Integer>> resList,int curSize,int len,boolean[] used,Stack<Integer> path){
        if(curSize == len){
            resList.add(new ArrayList(path));
            return ;
        }
        
        for(int i = 0; i < len; i++){
            //根据状态，判断分支是否已经记忆
            if(!used[i]){
                used[i] = true;
                path.add(nums[i]);
                //curSize 为每层独立空间中的数据
                geneatePermute(nums,resList,curSize + 1,len,used,path);
                //状态重置
                used[i] = false;
                path.pop();
            }
        }
    }
    
}