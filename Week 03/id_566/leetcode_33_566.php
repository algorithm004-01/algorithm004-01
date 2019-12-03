<?php
/**
 * 33. 搜索旋转排序数组
 * Author:show
 */
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
// 你可以假设数组中不存在重复的元素。
// 你的算法时间复杂度必须是 O(log n) 级别。

class Solution {
    function search($nums, $target) {
        if(count($nums) == 0) return -1;
        if(count($nums) == 1) return $nums[0]==$target?0:-1;
        $start = 0;
        $end = count($nums) - 1;
        while($start <= $end){
            $mid = floor($start + ($end - $start)/2);
            if($nums[$mid] == $target) return $mid;
            if($nums[$start] <= $nums[$mid]){//前半段都是有序的
                if($target >= $nums[$start] && $target < $nums[$mid]){
                    $end = $mid - 1;
                }else{
                    $start = $mid + 1;
                }
            }else{
                if($target > $nums[$mid] && $target <= $nums[$end]){
                    $start = $mid + 1;
                }else{
                    $end = $mid - 1;
                }
            }
        }
        return -1;
    }
}
?>