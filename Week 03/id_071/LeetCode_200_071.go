package week03

import (
	"container/list"
)

//1.2 https://leetcode-cn.com/problems/number-of-islands/
func numIslands(grid [][]byte) int {

	if grid == nil || len(grid) == 0 {
		return 0
	}

	dx := len(grid)
	dy := len(grid[0])
	num := 0
	for i := 0; i < dx; i++ {
		for j := 0; j < dy; j++ {
			if grid[i][j] == '1' {
				num++
				dfs(grid, i, j)
			}
		}
	}

	return num
}

func dfs(grid [][]byte, i int, j int) {
	dx := len(grid)
	dy := len(grid[0])
	if i < 0 || j < 0 || i >= dx || j >= dy || grid[i][j] == '0' {
		return
	}

	grid[i][j] = '0'

	dfs(grid, i - 1, j)
	dfs(grid, i + 1, j)
	dfs(grid, i, j - 1)
	dfs(grid, i, j + 1)
}

//queue 
func numIslandes (grid [][]byte) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}

	dx := len(grid)
	dy := len(grid[0])
	num := 0
	for i := 0; i < dx; i++ {
		for j := 0; i < dy; j++ {
			if grid[i][j] == '1' {
				num++
				bfs(grid, i, j)
			}
		}
	}

	return num
}

func bfs(grid [][]byte, i int, j int){
	grid[i][j] = '0'
	dx := len(grid)
	dy := len(grid[0])
	q := list.New()

	for q.Len() {

	}
}