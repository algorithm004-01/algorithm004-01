<?php
/**
 * 64. 最小路径和
 * Author:show
 */
// 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
// 说明：每次只能向下或者向右移动一步。
class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {
    $depth = count($grid);
    $len = count($grid[0]);
    $dp = $grid;
    for($i=1;$i<$depth;$i++) $dp[$i][0] += $dp[$i-1][0];
    for($i=1;$i<$len;$i++) $dp[0][$i] += $dp[0][$i-1];
        for($i=1;$i<$depth;$i++){
            for($j=1;$j<$len;$j++){
                $dp[$i][$j] = min($dp[$i-1][$j],$dp[$i][$j-1])+$grid[$i][$j];
            }
        }
        return $dp[$depth-1][$len-1];
    }
}
?>