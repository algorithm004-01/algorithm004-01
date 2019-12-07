package id_716

// https://leetcode-cn.com/problems/merge-sorted-array/

// 1. 新数组copy
func merge1(nums1 []int, m int, nums2 []int, n int)  {
	tmpRes := make([]int, m + n)

	i, j := 0, 0
	for i < m && j < n {
		if nums1[i] <= nums2[j] {
			tmpRes[i+j] = nums1[i]
			i++
		} else {
			tmpRes[i+j] = nums2[j]
			j++
		}
	}

	for i < m {
		tmpRes[i+n] = nums1[i]
        i++
	}
	for j < n {
		tmpRes[j+m] = nums2[j]
        j++
	}

	copy(nums1, tmpRes)
}

// 2. 原地移动，从后向前移动
func merge2(nums1 []int, m int, nums2 []int, n int)  {
	i, j := m - 1, n - 1
    for j >= 0 {
        if i >= 0 && nums1[i] >= nums2[j] {
            nums1[i+j+1] = nums1[i]
            i--
        } else {
            nums1[i+j+1] = nums2[j]
            j--
        }
    }
}

// 3. 排序法，这个就不做实现了，这个方式有点绕远了
// 伪代码：
//  nums2 append to nums1
//  sort nums1 (quick sort or merge sort)
