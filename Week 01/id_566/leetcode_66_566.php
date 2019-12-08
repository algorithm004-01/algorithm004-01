<?php
/**
 * 66.加一
 * Author:show
 */
// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

// 你可以假设除了整数 0 之外，这个整数不会以零开头。

class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits)
    {
        $length = count($digits);
        // echo "length:".$length."\n";
        // $tmp += 1;
        // $tmp = bcadd($tmp,1);
        //leetcode不能使用bcadd
        if($length<20)
        {
            $tmp = implode("",$digits);
            $tmp += 1;
            $tmp = str_split($tmp,1);
            return $tmp;
        }else{
            for($i=$length-1;$i>=0;$i--)
            {
                $digits[$i] += 1;
                if($digits[$i] > 9)
                {
                    $digits[$i] = 0;
                }else{
                    return $digits;
                }
            }
            array_unshift($digits, 1);
            return $digits;
        }
    }
}
?>