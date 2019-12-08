/*
 * @lc app=leetcode.cn id=189 lang=swift
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (38.99%)
 * Likes:    387
 * Dislikes: 0
 * Total Accepted:    72.7K
 * Total Submissions: 186.3K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {

    
    /*//环状替换解法
    func rotate(_ nums: inout [Int], _ k: Int) {

        let k = k % nums.count;
        var start = 0, count = 0

        while (count < nums.count) {

            var current = start
            var prev = nums[start]

            repeat {
                let next = (current + k) % nums.count
                let temp = nums[next]
                nums[next] = prev
                prev = temp
                current = next
                count += 1
            } while (start != current)

            start += 1
        }
    }
    */

    //反转解法
    func rotate(_ nums: inout [Int], _ k: Int) {
        let k = k % nums.count
        guard k != 0 else {
            return
        }
        reverse(&nums, 0, nums.count - 1);
        reverse(&nums, 0, k - 1);
        reverse(&nums, k, nums.count - 1);

    }

    func reverse(_ nums: inout [Int], _ start: Int, _ end: Int) {
        var start = start, end = end
        while (start < end) {
            let temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1
        }
    }
}

// @lc code=end

