<?php
/**
 * 46. 全排列
 * Author:show
 */
// 给定一个没有重复数字的序列，返回其所有可能的全排列。
class Solution {
    public $allList = [];
    function permute($nums) {
        $this->backtrack(0,count($nums),$nums);
        return $this->allList;
    }
    
    function backtrack($start,$count,$nums){
        if($start==$count){
            $this->allList[] = $nums;
        }else{
            for($i=$start;$i<$count;$i++){
                $this->swap($nums,$start,$i);
                $this->backtrack($start+1,$count,$nums);
                $this->swap($nums,$start,$i);
            }
        }
    }
    
    function swap(&$arr,$i,$j){
        $temp = $arr[$i];
        $arr[$i] = $arr[$j];
        $arr[$j] = $temp;
    }
}
?>