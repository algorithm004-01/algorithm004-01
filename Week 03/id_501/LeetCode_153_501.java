package homework.week03;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class LeetCode_153_501{
    /**
     * 暴力遍历
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min = nums[0];

        for(int i = 1;i < nums.length ; i ++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }

    /**
     * 二分法
     * @param nums
     * @return
     */
    public int findMin2(int[] nums){
        int left  = 0,right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[right]){
                left = mid  + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}