package algorithm00401

func maximalSquare(matrix [][]byte) int {
	if len(matrix) == 0 {
		return 0
	}
	square := make([][]int, len(matrix)+1)
	for i := range square {
		square[i] = make([]innt, len(matrix[0])+1)
	}
	maxSquare := 0
	for i := 1; i < len(square); i++ {
		for j := 1; j < len(square); j++ {
			if matrix[i-1][j-1] == '1' {
				square[i][j] = minInt(minInt(square[i-1][j], square[i][j-1]), square[i-1][j-1]) + 1
				if maxSquare < square[i] {
					maxSquare = square[i][j]
				}
			}
		}
	}
	return maxSquare * maxSquare
}

func minInt(i, j int) int {
	if i < j {
		return i
	}
	return j
}
