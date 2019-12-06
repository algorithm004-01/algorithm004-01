//经过三次反转操作，第一次是将整个数组从中间节点反转
//第二步是将前 k 个数字反转
//第三步是将 k - n 中间的数字反转
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}

//暴力法，双层循环，每次移动一个位置。移动的过程中，每次都要移动 n-1 个元素，然后需要移动 k 次
//时间复杂度: O(n*k);
//空间复杂度为: O(1);
class Solution {
    public void rotate(int[] nums, int k) {
        int temp = 0;
        for(int i = 0; i < k; i++){
            temp = nums[nums.length-1];
            for(int j = nums.length-1; j >= 1; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
}