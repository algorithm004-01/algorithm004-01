<?php
/**
 * 两数之和
 * Author:show
 */
// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $count = count($nums);
        for($i=0;$i<$count;$i++)
        {
            $ele = $target - $nums[$i];
            $keys = array_keys($nums,$ele);
            if($keys)
            {
                foreach($keys as $key)
                {
                    if($key!=$i)
                    {
                        return [$i,$key];
                    }
                }
            }
        }
        
    }
}
?>