// 双指针思路
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}


// 优化解法
// 完全无重复的时候减少元素移动
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                if(j - i > 1){
                    nums[i+1] = nums[j];
                }
                i++;
            }
        }
        return i+1;
    }
}