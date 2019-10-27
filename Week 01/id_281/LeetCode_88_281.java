/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    // O(n+m) O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指针 = 总数-1
        int p = m + n -1, p1 = m-1, p2 = n-1;

        while((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // 最后的个数就是索引+1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
// @lc code=end

