func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func _rob(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}
	if l == 1 {
		return nums[0]
	}
	if l == 2 {
		return max(nums[1], nums[0])
	}
	dp := make(map[int]int)
	dp[0] = nums[0]
	dp[1] = max(nums[1], nums[0])
	for i, n := range nums {
		if i == 0 || i == 1 {
			continue
		}

		dp[i] = max(dp[i-2]+n, dp[i-1])
	}
	return dp[l-1]
}
func rob(nums []int) int {
	l := len(nums)
    if l == 0 {
		return 0
	}
	if l == 1 {
		return nums[0]
	}
	if l == 2 {
		return max(nums[1], nums[0])
	}
	a := _rob(nums[1:])
	b := _rob(nums[:l-1])
	return max(a, b)
}
