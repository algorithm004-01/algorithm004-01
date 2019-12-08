//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1:
//
//
//输入: "aba"
//输出: True
//
//
// 示例 2:
//
//
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
//
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串
package com.aseara.leetcode.editor.cn.a680;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * desc: 680.验证回文字符串 Ⅱ <br />
 * Date: 2019/12/8 <br/>
 *
 * @author qiujingde
 */
class ValidPalindromeIi {
    private Solution solution = new Solution();

    @Test
    void test1() {
        assertTrue(solution.validPalindrome("aba"));
        assertTrue(solution.validPalindrome("abca"));
        assertFalse(solution.validPalindrome("abcd"));
        assertTrue(solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        return valid(s.toCharArray(), 0, s.length() - 1, false);
    }

    private boolean valid(char[] chars, int i, int j, boolean remove) {
        if (i >= j) {
            return true;
        }
        if (chars[i] == chars[j]) {
            return valid(chars, i + 1, j - 1, remove);
        }
        if (remove) {
            return false;
        }
        return valid(chars, i + 1, j, true) || valid(chars, i, j - 1, true);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
