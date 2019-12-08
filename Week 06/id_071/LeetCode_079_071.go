package week06

// 1.2 https://leetcode-cn.com/problems/word-search/
// dfs
func exist(board [][]byte, word string) bool {
	if len(board) == 0 {
		return false
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if dfs(board, i, j, word, 0){
				return true
			}
		}
	}
	return false
}

func dfs(board [][]byte, i, j int, word string, index int) bool {
	if index == len(word) {
		return true
	}

	if i >= len(board) || i < 0 || j >= len(board[0]) || j < 0 || word[index] != board[i][j] {
		return false
	}

	temp := board[i][j]
	board[i][j] = '%'

	a := dfs(board, i+1, j, word, index+1) || dfs(board, i, j+1, word, index+1) || dfs(board, i-1, j, word, index+1) || dfs(board, i, j-1, word, index+1)
	board[i][j] = temp
	
	return a
}