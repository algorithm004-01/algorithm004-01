/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 * 
 */
var merge = function(nums1, m, nums2, n) {
    nums1.splice(m, nums1.length - m, ...nums2) // O(n)
    nums1 = nums1.sort((n1, n2) => n1 - n2) // O(n+m) 
                                            //总时间 O(2n+m) = O(n+m)
};



/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 * 
 */
var merge = function(nums1, m, nums2, n) {
    // 前提， 数组是有序的
    let nums1_copy = nums1.slice(0, m)
    let p = 0; //-> num1 [1,2,3,0,0,0]
    let p1 = 0; //-> nums1_copy  [1,2,3]
    let p2 = 0; // -> num2 [2,5,6]

    while((p1 < m) && (p2 < n)) {
        nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++]
    }

    if(p1 < m) {
        nums1.splice(p, m + n - p1 - p2, ...nums1_copy.slice(p1))
    }
    if(p2 < n) {
        nums1.splice(p, m + n - p1 - p2, ...nums2.slice(p2))
    }
};