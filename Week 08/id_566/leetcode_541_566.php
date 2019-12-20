<?php
/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * Author:show
 */
// 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
// 示例:
// 输入: s = "abcdefg", k = 2
// 输出: "bacdfeg"
class Solution {
    /**
     * @param String $s
     * @param Integer $k
     * @return String
     */
    function reverseStr($s, $k)
    {
        $total = $single = '';
        $arr = str_split($s, $k*2);

        foreach ($arr as $key => $value) {
            $len = strlen($value);
            if ($len < $k) {
                $single = strrev($value);
            } else {
                $singArr = str_split($value, $k);
                $single = strrev($singArr[0]) . $singArr[1];
            }
            $total .= $single;
        }
        return $total;
    }

}
?>