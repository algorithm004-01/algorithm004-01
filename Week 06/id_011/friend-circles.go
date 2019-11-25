package algorithm00401

func findCircleNum(M [][]int) int {
	N := len(M)
	res := N

	friend := make([]int, res)
	for i := 0; i < res; i++ {
		friend[i] = i
	}

	for i := 0; i < N; i++ {
		for j := i + 1; j < N; j++ {
			if M[i][j] == 1 && friend[i] != friend[j] {
				res--
				union(friend[i], friend[j], friend)
			}
		}
	}

	return res
}

func union(x, y int, friend []int) {
	for i := 0; i < len(friend); i++ {
		if friend[i] == x {
			friend[i] = y
		}
	}
}
