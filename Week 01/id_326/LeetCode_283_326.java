
/**
 * Description: 283.移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明:
 * 1、必须在原数组上操作，不能拷贝额外的数组。
 * 2、尽量减少操作次数。
 *
 * @author qinxue
 * @date 2019-10-20 21:50:31
 */
class Solution {
    public void moveZeroes(int[] nums) {
        // leftMostZeroIndex永远都指向数组最左边的为零的元素的index
        int leftMostZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) {
                    nums[leftMostZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                leftMostZeroIndex++;
            }
        }
    }
}