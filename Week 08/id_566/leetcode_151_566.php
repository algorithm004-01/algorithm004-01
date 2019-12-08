<?php
/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * Author:show
 */
// 给定一个字符串，逐个翻转字符串中的每个单词。
// 示例 1：
// 输入: "the sky is blue"
// 输出: "blue is sky the"

class Solution {
    /**
     * @param String $s
     * @return String
     */
    function reverseWords($s) {
        $s = trim($s);
        $s2 = "";
        $j = strlen($s);
        for($i=strlen($s)-1;$i>0;$i--){
            if($s[$i]===' '){
                $s2 .= substr($s,$i+1,$j-$i-1)." ";
                while($s[$i-1]===' ') $i--;
                $j = $i;
            }
        }
        $s2 .= substr($s,0,$j);
        return $s2;
    }
}
?>