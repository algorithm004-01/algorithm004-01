//给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
//
// 示例 1:
//
// 输入: s = "egg", t = "add"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "foo", t = "bar"
//输出: false
//
// 示例 3:
//
// 输入: s = "paper", t = "title"
//输出: true
//
// 说明:
//你可以假设 s 和 t 具有相同的长度。
// Related Topics 哈希表
package com.aseara.leetcode.editor.cn.a205;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * desc: 205.同构字符串 <br />
 * Date: 2019/12/8 <br/>
 *
 * @author qiujingde
 */
class IsomorphicStrings {
    private Solution solution = new Solution();

    @Test
    void test1() {
        assertTrue(solution.isIsomorphic("egg", "add"));
        assertFalse(solution.isIsomorphic("foo", "bar"));
        assertTrue(solution.isIsomorphic("paper", "title"));
        assertFalse(solution.isIsomorphic("aa", "ab"));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < ss.length; i++) {
            char sc = ss[i];
            char tc = ts[i];
            if (sMap.computeIfAbsent(sc, c -> tc) != tc ||
                    tMap.computeIfAbsent(tc, c -> sc) != sc) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
