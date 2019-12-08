class Solution {
    //双指针解法
    public int removeDuplicates(int[] nums) {
       if(nums.length == 0){
           return 0;
       }
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            //判断是否为重复,往前移动
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        //从零开始+1
        return j+1;
    }
}