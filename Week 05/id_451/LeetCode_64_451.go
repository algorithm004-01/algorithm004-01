func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
func minPathSum(grid [][]int) int {
 if len(grid) == 0 {
		return 0
	}

	for j := 0; j < len(grid); j++ {
		row := grid[j]
		for i := 0; i < len(row); i++ {
			if i-1 < 0 && j-1 < 0 {
				continue
			}
			if j-1 < 0 {
				row[i] = row[i] + row[i-1]
				continue
			}
			if i-1 < 0 {
				row[i] = row[i] + grid[j-1][i]
				continue
			}
			row[i] = row[i] + min(row[i-1], grid[j-1][i])
		}
	}
	return grid[len(grid)-1][len(grid[len(grid)-1])-1]
}
