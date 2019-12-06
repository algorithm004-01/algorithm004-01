package algorithm00401

func isValidSudoku(board [][]byte) bool {
	var row, col, block [9]uint
	var cur uint

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] == '.' {
				continue
			}
			cur = 1 << (board[i][j] - '1')
			bi := i/3 + j/3*3
			if (row[i]&cur)|(col[j]&cur)|(block[bi]&cur) != 0 {
				return false
			}
			row[i] |= cur
			col[j] |= cur
			block[bi] |= cur
		}
	}
	return true
}
