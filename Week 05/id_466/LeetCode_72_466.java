//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
// 示例 1:
//
// 输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释:
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2:
//
// 输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释:
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
// Related Topics 字符串 动态规划
package com.aseara.leetcode.editor.cn.a72;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 72.编辑距离 <br />
 * Date: 2019/11/14 <br/>
 *
 * @author qiujingde
 */
class EditDistance {
    private Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(3, solution.minDistance("horse", "ros"));
        assertEquals(5, solution.minDistance("intention", "execution"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int m = word1.length();
        int n = word2.length();

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[] pre = new int[n + 1];
        int[] cur = new int[n + 1];

        for (int i = 1; i < pre.length; i++) {
            pre[i] = i;
        }

        for (int i = 0; i < m; i++) {
            cur[0] = i + 1;
            for (int j = 0; j < n; j++) {
                int up = pre[j + 1] + 1;
                int left = cur[j] + 1;
                int upLeft = pre[j] + (chars1[i] == chars2[j] ? 0 : 1);
                cur[j + 1] = Math.min(up, Math.min(left, upLeft));
            }
            System.arraycopy(cur, 0, pre, 0, n + 1);
        }

        return cur[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
