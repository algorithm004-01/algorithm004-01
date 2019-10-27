func merge(nums1 []int, m int, nums2 []int, n int)  {
	var i, j, k int
	nums3 := make([]int, n+m)
	if m == 0 || n == 0 {
		copy(nums1, nums2)
		return
	}
	for {
		if k == n+m {
			break
		}
		if j >= n || (nums1[i] < nums2[j] && i < m) {
			nums3[k] = nums1[i]
			k++
			i++
			continue
		}
		nums3[k] = nums2[j]
		k++
		j++
	}
	copy(nums1, nums3)
}
