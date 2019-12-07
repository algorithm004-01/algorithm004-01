package id_736


func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) < 1 || len(matrix[0]) < 1 {
		return false
	}

	// binary search for row's first elems
	rowsStart, rowsEnd := 0, len(matrix)-1
	for rowsStart <= rowsEnd {
		rowsMid := (rowsStart + rowsEnd) / 2
		if target < matrix[rowsMid][0] {
			rowsEnd = rowsMid - 1
			continue
		}
		if target > matrix[rowsMid][len(matrix[0])-1] {
			rowsStart = rowsMid + 1
			continue
		}

		// binary search for current row
		colsStart, colsEnd := 0, len(matrix[0])-1
		for colsStart <= colsEnd {
			colsMid := (colsStart + colsEnd) / 2
			switch {
			case target == matrix[rowsMid][colsMid]:
				return true
			case target < matrix[rowsMid][colsMid]:
				colsEnd = colsMid - 1
			case target > matrix[rowsMid][colsMid]:
				colsStart = colsMid + 1
			}
		}
		return false
	}
	return false
}
