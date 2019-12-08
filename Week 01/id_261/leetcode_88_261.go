// leetcode - https://leetcode-cn.com/problems/merge-sorted-array/

func merge(nums1 []int, m int, nums2 []int, n int)  {
    index := m + n - 1
    m = m - 1
    n = n - 1
    for index >= 0 {
        if n < 0 {
            return
        }
        if m < 0 || nums1[m] < nums2[n] {
            nums1[index] = nums2[n]
            n--
            index--
        } else {
            nums1[index] = nums1[m]
            m--
            index--
        }
    }
}