/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes1(int[] nums) {
        int i = 0;
        for (int j = 1; j <= nums.length - 1; j++) {
            if(nums[i] == 0) {
                if(nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }
            }else { 
                i++;
            }
        }

    }

    // 先把非0元素填充在前面位置，后面的在补0
    public void moveZeroes2(int[] nums) {
        int lastNonZerosIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZerosIndex++] = nums[i]; 
            }
        }

        for (int i = lastNonZerosIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 递推非0指针的位置
    public void moveZeroes(int[] nums) {
        int lastNonZerosIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if (i > lastNonZerosIndex) {
                    nums[lastNonZerosIndex] = nums[i];
                    nums[i] = 0;
                }
                lastNonZerosIndex ++;
            }
        }
    }
}
// @lc code=end

