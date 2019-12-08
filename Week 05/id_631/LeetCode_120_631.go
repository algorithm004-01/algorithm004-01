func minimumTotal(triangle [][]int) int {
    row := len(triangle)
    dp  := make([]int, row + 1)
    
    for i := row - 1; i >= 0; i-- {
        for j := 0;j < len(triangle[i]); j++ {
            min := dp[j]
            if dp[j] > dp[j+1] {
                min = dp[j+1]
            }
            dp[j] = min + triangle[i][j];
        }
    }
    return dp[0];
}