/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-03 11:54
 **/

public class Leetcode_153_371 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7,0, 1, 2};
        int min = findMin(nums);
        System.out.println("min = " + min);
    }

    /**
     * 原解1:二分查找(每次确定剩下空间的最小值,和之前已确定的空间最小值进行比较)
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int min = nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //1.左边有序,记录左边最小值, 继续在右边搜索
            if (nums[mid] >= nums[0]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                //2.右边有序,记录右边的最小值,继续在左边搜索
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }

}
