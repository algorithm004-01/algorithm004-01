//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [3,4,5,1,2]
//输出: 1
//
// 示例 2:
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0
// Related Topics 数组 二分查找
package com.aseara.leetcode.editor.cn.a153;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 153.寻找旋转排序数组中的最小值 <br />
 * Date: 2019/11/3 <br/>
 *
 * @author qiujingde
 */
class FindMinimumInRotatedSortedArray {
    private Solution solution = new Solution();

    @Test
    void test1() {
        int[] test = new int[] {3,4,5,1,2};
        assertEquals(1, solution.findMin(test));

        test = new int[] {4,5,6,7,0,1,2};
        assertEquals(0, solution.findMin(test));

        test = new int[] {1,2,3};
        assertEquals(1, solution.findMin(test));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int index = binarySearch(nums, 0, nums.length - 1);
        return nums[index];
    }

    private int binarySearch(int[] nums, int start, int end) {
        if (start == end) {
            return end;
        }

        if (end - start == 1) {
            if (nums[start] > nums[end]) {
                return end;
            }
            return 0;
        }

        int mid = start + (end - start) / 2;
        // 从 mid 到 end 正序
        if (nums[mid] < nums[end]) {
            if (nums[mid - 1] > nums[mid]) {
                return mid;
            }
            end = mid - 1;
        } else {
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            start = mid + 1;
        }
        return binarySearch(nums, start, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
