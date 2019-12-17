package algorithm00401

func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}
	res := 0

	n := len(grid)
	m := len(grid[0])
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if grid[i][j] == '1' {
				res++
				inflect(grid, i, j, n, m)
			}
		}
	}
	return res
}

func inflect(grid [][]byte, i, j, n, m int) {
	if i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1' {
		return
	}
	grid[i][j] = '2'
	inflect(grid, i+1, j, n, m)
	inflect(grid, i-1, j, n, m)
	inflect(grid, i, j+1, n, m)
	inflect(grid, i, j-1, n, m)
}
