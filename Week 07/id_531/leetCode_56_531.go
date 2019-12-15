package id_531

import "sort"

type ByRow [][]int

func (b ByRow) Len() int {
	return len(b)
}

func (b ByRow) Swap(i, j int) {
	b[i], b[j] = b[j], b[i]
}

func (b ByRow) Less(i, j int) bool {
	return b[i][0] < b[j][0]
}

func merge(intervals [][]int) [][]int {
	res := make([][]int, 0)
	if len(intervals) == 0 {
		return res
	}
	sort.Sort(ByRow(intervals))
	tmp := make([]int, 2)
	tmp[0] = intervals[0][0]
	tmp[1] = intervals[0][1]

	for i := 1; i < len(intervals); i++ {

		if tmp[1] >= intervals[i][0] {
			if tmp[1] < intervals[i][1] {
				tmp[1] = intervals[i][1]
			}
		} else {
			res = append(res, []int{tmp[0], tmp[1]})
			tmp[0] = intervals[i][0]
			tmp[1] = intervals[i][1]
		}
	}

	res = append(res, []int{tmp[0], tmp[1]})

	return res
}
