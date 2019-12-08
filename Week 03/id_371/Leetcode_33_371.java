/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-03 11:53
 **/

public class Leetcode_33_371 {

    public static void main(String[] args) {
        int[] nums = {3, 1};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2,3};
        int target = 1;
        int index = search(nums, target);
        System.out.println("index = " + index);
    }

    /**
     * 仿解1:二分查找(判断升序)
     *
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
//        int mid = left + (right - left) / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //出口
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {//mid的左边升序(left-mid)
                if (target <= nums[mid] && target >= nums[left]) {//在左边
                    right = mid - 1;
                } else {//在右边
                    left = mid + 1;
                }
            } else {//右边升序
                if (target >= nums[mid] && target <= nums[right]) {//在右边搜
                    left = mid + 1;
                } else {//去左边
                    right = mid - 1;
                }

            }
//            mid = left + (right - left) / 2;
        }
        return -1;
    }
}
