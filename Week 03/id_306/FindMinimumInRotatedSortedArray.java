/**
 * Created by LynnSun on 2019/11/3.
 * 力扣题目地址：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            //找到数组的中间元素 mid。
            int mid = (left + right) / 2;
            /*如果中间元素 > 数组第一个元素，变化点在右边。
            如果中间元素 < 数组第一个元素，变化点在左边*/
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
