package com.yiche;

/**
 * @auther: TKQ
 * @Title: Rotate_189
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-10-20 17:28
 */
public class Rotate_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums,int start,int end){

        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;end--;
        }
    }

    /**
     * 暴力破解
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        for(int i=0;i<k;i++){
            int moveToPre = nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                int temp = nums[j];
                nums[j] = moveToPre;
                moveToPre = temp;
            }
        }
    }
}
//runtime:0 ms
//memory:37.1 MB
