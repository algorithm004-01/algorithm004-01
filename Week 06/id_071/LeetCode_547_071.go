package week06

//2.2 https://leetcode-cn.com/problems/friend-circles/

func findCircleNum(M [][]int) int {
	if len(M) <= 1 {
		return len(M)
	}

	count := 0
	visited := make([]bool,len(M))
	for i, _ := range M {
		if visited[i] == false {
			BFS(M, visited, i)
			count++
		}
	}

	return count
}

func dfs(M [][]int, visited []bool, c int){
	for j := 0; j < len(M); j++ {
		if M[c][j] == 1 && visited[j] == false {
			visited[j] = true
			dfs(M, visited, j)
		}
	}
}


func BFS(M [][]int, visited []bool, c int){
	new := make([]int, 0)
	new = append(new, c)
	visited[c] = true
	
	for len(new) > 0 {
		c = new[0]
		new = new[1:]

		for i := 0; i < len(M); i++ {
			if M[c][i] == 1 && visited[i] == false{
				visited[i] = true
				new = append(new, i)
			}
		}
	}
}