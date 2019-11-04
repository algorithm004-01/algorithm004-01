package search_in_rotated_sorted_array;

class Solution {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

     ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

     搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

     你可以假设数组中不存在重复的元素。

     你的算法时间复杂度必须是 O(log n) 级别。

     示例 1:

     输入: nums = [4,5,6,7,0,1,2], target = 0
     输出: 4
     示例 2:

     输入: nums = [4,5,6,7,0,1,2], target = 3
     输出: -1

     * */
    public int search(int[] nums, int target) {
        /**
         *将数组一分为二，分别对两边进行区间二分
         * */
        int left = 0;
        int rigth = nums.length-1;
        while (left <= rigth){
            int mid = (left + rigth)/2;
            if(nums[mid] == target) return mid;
            //当左半天有序时
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid] ){
                    rigth = mid -1;
                }else {
                    left = mid + 1;
                }
            }else {//当右半边有序时
                if(target > nums[mid] && target <= nums[rigth]){
                    left = mid + 1;
                }else {
                    rigth = mid -1;
                }
            }
        }

        return -1;
    }

}