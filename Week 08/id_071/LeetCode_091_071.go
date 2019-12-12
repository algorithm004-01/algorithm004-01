package week08

import "strconv"

//1.2 https://leetcode-cn.com/problems/decode-ways/
func numDecodings(s string) int {

	if s == "0" {
		return 0
	}

	if len(s) <= 1 {
		return 1
	}

	dp := make([]int, len(s)+1)
	dp[0], dp[1] = 1, 1
	if s[0] == '0' {
		dp[1] = 0
	}
	for i := 2; i <= len(s); i++ {
		if signle, _ := strconv.Atoi(s[i-1: i]); signle > 0 {
			dp[i] = dp[i-1]
		}

		if double, _ := strconv.Atoi(s[i-2: i]);double >= 10 && double <= 26 {
			dp[i] += dp[i-2]
		}
	}

	return dp[len(s)]
}