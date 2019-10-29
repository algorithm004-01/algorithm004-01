<?php
/**
 * 47. 全排列 II
 * Author:show
 */
// 给定一个可包含重复数字的序列，返回所有不重复的全排列。

class Solution {

    public $allList = [];
    function permuteUnique($nums) {
        sort($nums);
        $this->backtrack($nums,0,[],[]);
        return $this->allList;
    }
    
    function backtrack($nums,$depth,$stack,$used){
        if($depth==count($nums)){
            $this->allList[] = $stack;
        }else{
            for($i=0;$i<count($nums);$i++){
                if(1==$used[$i]) continue;
                if($i>0 && $nums[$i]==$nums[$i-1] && !$used[$i-1]){
                    continue;
                }
                $used[$i] = 1;
                array_push($stack,$nums[$i]);
                $this->backtrack($nums,$depth+1,$stack,$used);
                $used[$i] = 0;
                array_pop($stack);
            }
        }
    }
}
?>