package week05

//1.1 https://leetcode-cn.com/problems/minimum-path-sum/

func minPathSum(grid [][]int) int {
    R := len(grid)
	if R == 0 {
		return 0
	}
	C := len(grid[0])
	if C == 0 {
		return 0
	}
	for c := 1; c != C; c++ { // first row
		grid[0][c] += grid[0][c-1]
	}
	for r := 1; r != R; r++ {
		grid[r][0] += grid[r-1][0]
		for c := 1; c != C; c++ {
			grid[r][c] += min(grid[r-1][c], grid[r][c-1])
		}
	}
	return grid[R-1][C-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func minPathSums(grid [][]int) int {
	mlen := len(grid)
	if mlen == 0 {
		return 0
	}
	nlen := len(grid[0])
	if nlen == 0 {
		return 0
	}

	dp := initDP(mlen, nlen)
	initFirstCol(dp, grid)
	initFirstRow(dp, grid)

	for i := 1; i < mlen; i++ {
		for j := 1; j < nlen; j++ {
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}
	return dp[mlen-1][nlen-1]
}

func initDP(mlen, nlen int) [][]int {
	dp := make([][]int, mlen)
	for i := 0; i < mlen; i++ {
		dp[i] = make([]int, nlen)
	}
	return dp
}

func initFirstCol(dp, grid [][]int) {
	for i := 0; i < len(dp); i++ {
		if i == 0 {
			dp[i][0] = grid[i][0]
		} else {
			dp[i][0] = grid[i][0] + dp[i-1][0]
		}
	}
}

func initFirstRow(dp, grid [][]int) {
	for i := 0; i < len(dp[0]); i++ {
		if i == 0 {
			dp[0][i] = grid[0][i]
		} else {
			dp[0][i] = grid[0][i] + dp[0][i-1]
		}
	}
}