//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0, nonZero = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 直接交换则无需判断，减少程序判断的停留
                int temp = nums[nonZero];
                nums[nonZero] = nums[i];
                nums[i] = temp;
                nonZero++;
            }
        } // for
    } // moveZeroes
}
//leetcode submit region end(Prohibit modification and deletion)
