package week06

//3.1 https://leetcode-cn.com/problems/n-queens/
func solveNQueens(n int) [][]string {
	var res [][]string
	doSolve(&res,n,[]int{})
	return res
}

func doSolve(res *[][]string, n int, path []int) {
	if len(path) == n {
		var queenPrint []string
		for _, q := range path {
			var line bytes.Buffer
			i := 1
			for i < q {
				line.WriteString(".")
				i++
			}
			line.WriteString("Q")
			i = q + 1
			for i <= n {
				line.WriteString(".")
				i++
			}
			queenPrint = append(queenPrint,line.String())
		}
		*res = append(*res, queenPrint)
		return 
	}

		var queenX = len(path) + 1
	OUTLOOP:
		for queenY := 1; queenY <= n; queenY++ {
			for i, existQueenY := range path {
				existQueenX := i + 1
				if existQueenX + existQueenY = queenY + queenX || existQueenY == queenY || existQueenX - existQueenY == queenX - queenY {
					continue OUTLOOP
				}
			}
			path = append(path,queenY)
			doSolve(res,n,path)
			path = path[:len(path) - 1]
		}
}