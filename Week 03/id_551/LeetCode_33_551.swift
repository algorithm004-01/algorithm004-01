class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        // 旋转排序数组：有限制的有序数组，
        // 要求：O(logn), 不能 for 一遍
        // 二分查找的前提：1、单调性；2、有界限（bounded）；3、能够通过索引访问；
        // 关键点：除了某个节点突然下降外是升序数组，1. 找单边有序(nums[mid] < nums[hi], 则右边有序) 2.规约
        var lo = 0
        var hi = nums.count - 1
        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2
            if target == nums[mid] {
                return mid
            }
            if nums[mid] < nums[hi] {
                // 右边有序
                if target <= nums[hi] && target > nums[mid] {
                    // target 在右边，开始向右规约
                    lo = mid + 1
                } else {
                    // target 在左边，开始规约
                    hi = mid - 1
                }
            } else {
                // 左边有序
                if target >= nums[lo] && target < nums[mid] {
                    // target 在左边，开始向左规约
                    hi = mid - 1
                } else {
                    // target 在右边，开始向右规约
                    lo = mid + 1
                }
            }
        }
        return -1
    }
}
