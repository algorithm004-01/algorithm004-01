package homework.week03;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class LeetCode_33_501{
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        // 找到最大值的数据下标
        while (start < end){
             int mid = Math.round(((float)start + end) / 2);
             if(nums[mid] < nums[start]){
                end = mid - 1;
             }else{
                 start = mid;
             }
        }

        int n = nums.length;
        int bias = (start + n) - (n -1);
        start = 0;
        end  =  nums.length - 1;
        while(start <= end){
            int mid = (start + end) /2 ;
            int mid_change = (mid + bias) % nums.length;
            int value = nums[mid_change];

            if(target == value){
                return mid_change;
            }
            if(target < value){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}