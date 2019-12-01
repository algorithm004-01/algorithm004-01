//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学
package com.aseara.leetcode.editor.cn.a231;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * desc: 231.2的幂 <br />
 * Date: 2019/11/26 <br/>
 *
 * @author qiujingde
 */
class PowerOfTwo {
    private Solution solution = new Solution();

    @Test
    void test1() {
        assertFalse(solution.isPowerOfTwo(0));
        assertTrue(solution.isPowerOfTwo(1));
        assertTrue(solution.isPowerOfTwo(2));
        assertFalse(solution.isPowerOfTwo(3));
        assertTrue(solution.isPowerOfTwo(4));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
