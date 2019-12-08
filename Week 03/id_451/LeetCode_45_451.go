func min(ns ...int) int {
	t := 1<<32 - 1
	for _, n := range ns {
		if n < t {
			t = n
		}
	}
	return t
}
func jump(nums []int) int {
	l := len(nums)
	dp := make([]int, l)
	dp[l-1] = 0
	for i := l - 2; i >= 0; i-- {
		n := nums[i]
		dp[i] = 1<<32 - 1
		for j := i + 1; j <= l-1 && j <= i+n; j++ {
			dp[i] = min(dp[i], dp[j]+1)
		}
	}
	return dp[0]
}
