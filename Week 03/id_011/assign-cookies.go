package algorithm00401

import "sort"

func findContentChildren(g []int, s []int) int {
	sort.Sort(sort.Reverse(sort.IntSlice(g)))
	sort.Sort(sort.Reverse(sort.IntSlice(s)))

	var res int
	gi, si := 0, 0
	for gi < len(g) && si < len(s) {
		if s[si] >= g[gi] {
			res++
			gi++
			si++
		} else {
			gi++
		}
	}
	return res
}
