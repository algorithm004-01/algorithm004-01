package id_531

func maximalSquare(matrix [][]byte) int {
	rows := len(matrix)
	var cols int
	if rows > 0 {
		cols = len(matrix[0])
	}
	dp := make([][]int, rows+1)
	for i := 0; i <= rows; i++ {
		dp[i] = make([]int, cols+1)
	}
	var maxSquare int
	for i := 1; i <= rows; i++ {
		for j := 1; j <= cols; j++ {
			if matrix[i-1][j-1] == '1' {
				dp[i][j] = min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
				if maxSquare < dp[i][j] {
					maxSquare = dp[i][j]
				}
			}
		}
	}
	return maxSquare * maxSquare
}

//func min(i, j int) int {
//	if i < j {
//		return i
//	}
//	return j
//}
