//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划
package com.aseara.leetcode.editor.cn.a91;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 91.解码方法 <br />
 * Date: 2019/11/15 <br/>
 *
 * @author qiujingde
 */
class DecodeWays {
    private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(2, solution.numDecodings("12"));
        assertEquals(3, solution.numDecodings("226"));
        assertEquals(1, solution.numDecodings("110"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] memo = new int[chars.length + 2];
        memo[chars.length] = 1;

        int before = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int curNum = chars[i] - '0';
            if (curNum == 0) {
                memo[i] = 0;
            } else if (curNum == 1 || (curNum == 2 && before < 7)) {
                memo[i] = memo[i + 1] + memo[i + 2];
            } else {
                memo[i] = memo[i + 1];
            }
            before = curNum;

        }

        return memo[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
