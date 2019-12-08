//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
package com.aseara.leetcode.editor.cn.a1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: <br />
 * Date: 2019/10/10 <br/>
 *
 * @author qiujingde
 */
class TwoSum {
    private Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] expected = new int[] { 0, 1 };
        assertArrayEquals(expected, twoSum(nums, target));
    }

    private int[] twoSum(int[] nums, int target) {
        return solution.twoSum(nums, target);
    }
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null) {
                result[0] = j;
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
