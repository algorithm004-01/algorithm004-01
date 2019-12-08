package week06

//2.1 https://leetcode-cn.com/problems/number-of-islands/
func numIslands(grid [][]byte) int {
	mlen := len(grid)
	if mlen == 0 {
		return 0
	}

	nlen := len(grid[0])
	
	res, visited := 0, newVisited(mlen, nlen)
	for i := 0; i < mlen; i++ {
		for j := 0; j < nlen; j++ {
			if grid[i][j] == '1' && visited[i][j] == 0 {
				res++
				fill(grid, visited, i, j, mlen, nlen)
			}
		}
	}
	return res
}

func fill( grid [][]byte, visited [][]int, i, j int, mlen, nlen int){
	visited[i][j] = 1
	if i-1 >= 0 && grid[i-1][j] == '1' && visited[i-1][j] == 0 {
		fill(grid, visited, i-1, j, mlen, nlen)
	}

	if i+1 >= 0 && grid[i+1][j] == '1' && visited[i+1][j] == 0 {
		fill(grid, visited, i+1, j, mlen, nlen)
	}

	if j-1 >= 0 && grid[i][j-1] == '1' && visited[i][j-1] == 0 {
		fill(grid, visited, i, j-1, mlen, nlen)
	}

	if j+1 >= 0 && grid[i][j+1] == '1' && visited[i][j+1] == 0 {
		fill(grid, visited, i, j+1, mlen, nlen)
	}
}

func newVisited(m, n int ) [][]int {
	v := make([][]int, m)
	for i := 0; i < m; i++ {
		v[i] = make([]int, n)
	}
	return v
}

