/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i+k) % nums.length] = nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            nums[j] = newNums[j];
        }
    }
}
// @lc code=end



/**
 * 给定步数将数组的所有的元素向右移动
 * 1 创建一个新数组
 *   当小于K时，遍历数组，创建一个新的数组，当i通过(i+k)%length位移到新的位置
 *   完成后将新数组拷贝回原数组，关于这个计算公式的想法：每个下标被下令右移时有超出
 *   数组长度的可能，超出的位置回到数组头部重新计算，因此比数组长度长多少就是解，
 *   所以用取余的方式获得. 时O(2n) 空O(n)
 * 
 * 2 暴力解法
 *   旋转k次就挪动k次,不创建新的数组时就要保存元素，否则会被覆盖
 *   时O(n*k)  空O(1)
 * 
 * 3 环状替代
 *   在同一个数组中移动替换元素，相当于执行length次将要替换的元素放到(i+k)%length的位置上去
 *   当n%k=0的时候，n/k个数字的下标会重复循环移动的过程，这n/k个数字是一组，为了遍历所有数字
 *   需要相同的操作去操作k个组
 * 
 */
