/**
 * LeetCode_33_576
 */
public class LeetCode_33_576 {
    
    //1. 暴力法：还原（logn）-》升序 -》二分：写在第三周总结力
    public int search1(int[] nums, int target) {
        return 0;
    }
    //2. 二分查找
    public int search2(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            //当[0,mid]有序时，向后规约条件
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                lo = mid + 1;
                //当[0,mid]发生旋转时，向后规约条件
            } else if (target > nums[mid] && target < nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}