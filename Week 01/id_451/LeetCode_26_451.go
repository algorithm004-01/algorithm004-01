func removeDuplicates(nums []int) int {
	var pre, j int
	for i, n := range nums {
		if i == 0 {
			pre = n
			j = 1
			continue
		}
		if n == pre {
			continue
		}

		pre = n
		nums[j] = n
		j++
	}
	return j
}

