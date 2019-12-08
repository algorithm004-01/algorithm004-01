var ret [][]int

func combine1(n int, k int) [][]int {
	ret = [][]int{}
	combine1r(n, k, []int{})
	return ret
}

func combine1r(n int, k int, includ []int) {
	if k == 0 {
		ret = append(ret, includ)
		return
	}

	for i := 1; i <= n; i++ {
		if contains(includ, i) {
			return
		}

		include := append([]int{}, i)
		include = append(include, includ...)
		combine1r(n, k - 1, include)
	}
}

func contains(a []int, t int) bool {
	for _, v := range a {
		if v == t {
			return true
		}
	}

	return false
}