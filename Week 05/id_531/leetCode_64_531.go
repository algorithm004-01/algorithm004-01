package id_531

// 暴力
func MinPathSumBrust(grid [][]int) int {
	// 1. 终止条件
	// 2. 当成逻辑
	// 3. 下层逻辑
	// 4. 恢复状态
	return 0
}

//  DP
// a. 分治（重复子问题）：pb(m,n)=min(sub(m,n+1),sub(m+1,n))+grid(m,n)
// b. 定义状态空间: grid[m][n]: 左上角到m行n 列中数字和
// c. DP 方程 f[m][n]=min
func minPathSum(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			if i == m-1 && j != n-1 {
				dp[i][j] = grid[i][j] + dp[i][j+1]
			} else if j == n-1 && i != m-1 {
				dp[i][j] = grid[i][j] + dp[i+1][j]
			} else if i != m-1 && j != n-1 {
				dp[i][j] = grid[i][j] + min(dp[i+1][j], dp[i][j+1])
			} else {
				dp[i][j] = grid[i][j]
			}
		}
	}
	return dp[0][0]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
