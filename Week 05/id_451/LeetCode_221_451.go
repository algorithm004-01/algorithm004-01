func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func maximalSquare(grid [][]byte) int {
		if len(grid) == 0 {
		return 0
	}
	res := 0
	for j := 0; j < len(grid); j++ {
		row := grid[j]
		for i := 0; i < len(row); i++ {
			 row[i] = row[i] - 48
			if i-1 < 0 || j-1 < 0 {
				res = max(res, int(row[i]))
				continue
			}
			if grid[j][i] == 1 {
				grid[j][i] = byte(min(int(grid[j-1][i-1]), min(int(grid[j-1][i]), int(grid[j][i-1]))) + 1)
				res = max(res, int(grid[j][i]))
			}

			//println(`?`, j, i, row[i])
		}
	}
	return res * res
}
