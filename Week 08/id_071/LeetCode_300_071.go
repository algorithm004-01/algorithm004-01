package week08

//1.1 https://leetcode-cn.com/problems/longest-increasing-subsequence/
func lengthOfLIS(nums []int) int {

	if len(nums) == 1 {
		return 1
	}

	if len(nums) == 0 {
		return 0
	}

	dp := make([]int, len(nums))

	for i := 0; i < len(nums); i++ {
		dp[i] = 1
	}

	max := 1
	for i := 1; i < len(nums); i++ {
		for j := 0; j < i; j++ {
            curProblem := dp[i]
			if nums[i] > nums[j] {
				if dp[j]+1 > curProblem {
                    dp[i]++
                    curProblem := dp[i]
					if max < curProblem {
						max = curProblem
					}
				}
			}
		}
	}

	return max
}
