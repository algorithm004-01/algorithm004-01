//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,1]
//
// 示例 2:
//
// 输入: 5
//输出: [0,1,1,2,1,2]
//
// 进阶:
//
//
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
//
// Related Topics 位运算 动态规划
package com.aseara.leetcode.editor.cn.a338;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * desc: 338.比特位计数 <br />
 * Date: 2019/11/25 <br/>
 *
 * @author qiujingde
 */
class CountingBits {
    private Solution solution = new Solution();

    @Test
    void test1() {
        assertArrayEquals(new int[]{0}, solution.countBits(0));
        assertArrayEquals(new int[]{0, 1}, solution.countBits(1));
        assertArrayEquals(new int[]{0, 1, 1}, solution.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2}, solution.countBits(3));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1}, solution.countBits(4));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, solution.countBits(5));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] += result[i & (i - 1)] + 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
