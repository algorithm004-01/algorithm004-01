<?php
/**
 * 455. 分发饼干
 * Author:show
 */
// 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

class Solution {

    /**
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    function findContentChildren($childrens, $cookies) {
        $sum = 0;
        //实际可以不用php的sort,自己写一个sort的函数
        sort($childrens);
        sort($cookies);
        foreach($cookies as $cookies_num => $cookie)
        {
            foreach($childrens as $children_num => $children)
            {
                if($cookie >= $children)
                {
                    $sum++;
                    unset($childrens[$children_num]);
                    break;
                }
            }
        }
        return $sum;
    }
}
?>