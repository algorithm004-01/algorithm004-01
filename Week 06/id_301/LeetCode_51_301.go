package id_301

func solveNQueens(n int) [][]string {
	if n == 0 {
		return nil
	}
	res := make([][]int, 0)
	//存放列，撇，捺
	cols := make(map[int]bool, n)
	pies := make(map[int]bool, n)
	nas := make(map[int]bool, n)
	dfs([]int{}, n, cols, pies, nas, &res)
	return generateResult(res, n)
}

func dfs(rows []int, n int, cols, pies, nas map[int]bool, res *[][]int) {
	//出递归的条件
	row := len(rows)
	if row == n {
		tmp := make([]int, len(rows))
		copy(tmp, rows)
		(*res) = append((*res), tmp)
		return
	}
	//对于每一层就遍历所有的列
	for col := 0; col < n; col++ {
		//当列，撇，捺中都不存在对应的值时，将其加入
		if !cols[col] && !pies[row+col] && !nas[row-col] {
			//开始更新列撇捺的值
			cols[col] = true
			pies[row+col] = true
			nas[row-col] = true
			//递归执行下一层操作
			dfs(append(rows, col), n, cols, pies, nas, res)
			//每一次递归完成后将原有的标志位清空,以方便下一层搜索
			cols[col] = false
			pies[row+col] = false
			nas[row-col] = false
		}
	}
}

func generateResult(res [][]int, n int) (result [][]string) {
	for _, v := range res {
		var s []string
		for _, val := range v {
			str := ""
			for i := 0; i < n; i++ {
				if i == val {
					str += "Q"
				} else {
					str += "."
				}
			}
			s = append(s, str)
		}
		result = append(result, s)
	}
	return
}
