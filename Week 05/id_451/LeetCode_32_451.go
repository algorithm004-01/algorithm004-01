
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func longestValidParentheses(s string) int {

	dp := make([]int, len(s))
	res := 0
	for i, a := range s {
		if i == 0 {
			continue
		}
		if a == ')' && s[i-1] == '(' {
			if i-2 < 0 {
				dp[i] = 2
			} else {
				dp[i] = dp[i-2] + 2
			}
		}
		if a == ')' && s[i-1] == ')' {
			if i-1-dp[i-1] >= 0 && s[i-1-dp[i-1]] == '(' {
				dp[i] = dp[i-1] + 2
				if i-1-dp[i-1]-1 >= 0 {
					dp[i] += dp[i-1-dp[i-1]-1]
				}
			}
		}
		res = max(res, dp[i])
	}
	return res
}
