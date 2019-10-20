package cn.leetcode;

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

public class LeetCode_283_351 {

    /**
     * 将
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //1)将非0元素往前移动,用index来记录最后非零元素的位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        //2)末尾补零...
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //02更为高效的方法,用零时变量交换....
    public void moveZeroes1(int[] nums) {
        int offset = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                int temp = nums[offset];
                nums[offset] = nums[index];
                nums[index] = temp;
                offset++;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
