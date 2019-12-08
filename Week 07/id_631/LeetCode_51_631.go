var res [][]int

//位运算实现
// 98.31% 100%
func solveNQueens(n int) [][]string {
    if n == 0 {
        return nil
    }
    res = make([][]int, 0)
    dfs([]int{}, n, 0, 0, 0)
    return generateResult()
}

func dfs(rows []int, n, cols, pies, nas int){
    //终止条件
    if len(rows) == n {
        tmp := make([]int, n)
        copy(tmp, rows)
        res = append(res, tmp)
        return
    }

    ok:= (^(cols | pies | nas)) & ((1 << uint(n)) - 1)
    for ok != 0 {
        p := ok & (-ok)
        col := 0
        s := (1 << uint(n - 1))
        for p & s == 0 {
            col++
            s >>= 1
        }
        dfs(append(rows, col), n, cols ^ p, (pies ^ p) << 1, (nas ^ p) >> 1)
        ok ^= p 
    }
}

func generateResult() (result [][]string) {
    str := ""
	for _, v := range res {
		var s []string
        n := len(v)
		for _, val := range v {
            str = ""
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
