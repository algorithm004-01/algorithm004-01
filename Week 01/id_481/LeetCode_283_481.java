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

package leetcode.editor.cn;

import java.util.Arrays;

//Java：移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,0,3,12};
        //利用冒泡的思想实现了一个二的方法 时间复杂度为 n^2
        Solution01 solution = new P283MoveZeroes().new Solution01();
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        int[] test = {1,2,0,0,1,0,0,3,12};
        Solution02 solution1 = new P283MoveZeroes().new Solution02();
        solution1.moveZeroes(test);
        System.out.println(Arrays.toString(test));

        int[] test3 = {1,2,0,0,1,0,0,3,12};
        Solution03 solution03 = new P283MoveZeroes().new Solution03();
        solution03.moveZeroes(test3);
        System.out.println(Arrays.toString(test3));

    }

    class Solution03 {
        //思考： 这个理解起来是比较顺的， 先把非0找好位置，剩下的补0
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }
            for (int i = j; i <= nums.length - 1; i++) {
                nums[i] = 0;
            }
        }
    }


    class Solution02 {
        //思考：要注意 i != j 在设置i的值
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution01 {
        //基于冒泡的思想
        public void moveZeroes(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] == 0) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
