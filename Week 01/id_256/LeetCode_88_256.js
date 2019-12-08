/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    //splice截取 合并 排序
    //   nums1.splice(m, nums1.length - m);
    //   nums2.splice(n, nums2.length - n);
    //   Object.assign(nums1, [...nums1, ...nums2]).sort((a, b) => a - b);
  
    // 得用数组有序
    let pos = m + n - 1;
    while (n > 0) {
      if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
        nums1[pos--] = nums1[m - 1];
        m--;
      } else {
        nums1[pos--] = nums2[n - 1];
        n--;
      }
    }
  };
  // @lc code=end
  