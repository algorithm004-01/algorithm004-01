//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组
package com.aseara.leetcode.editor.cn.a66;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 加一 <br />
 * Date: 2019/10/20 <br/>
 *
 * @author qiujingde
 */
class PlusOne {
    private Solution solution = new Solution();

    @Test
    void test1() {
        int[] test = new int[] {1,2,3};
        int[] result = new int[] {1,2,4};
        assertArrayEquals(result, solution.plusOne(test));

        test = new int[] {4,3,2,1};
        result = new int[] {4,3,2,2};
        assertArrayEquals(result, solution.plusOne(test));

        test = new int[] {9};
        result = new int[] {1,0};
        assertArrayEquals(result, solution.plusOne(test));

        test = new int[] {2,9};
        result = new int[] {3,0};
        assertArrayEquals(result, solution.plusOne(test));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                int[] result = new int[ digits.length ];
                System.arraycopy(digits, 0, result, 0, i);
                result[i] = digits[i] + 1;
                return result;
            }
        }
        int[] result = new int[ digits.length + 1 ];
        result[0] = 1;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
