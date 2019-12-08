type state struct {
	s [][]int
}

func (s *state) Add(n int) {
	ok := true
	for i, l := range s.s {
		if n >= l[0] {
			ok = false
		}
		if n > l[len(l)-1] {
			s.s[i] = append(l, n)
		} else {
			if len(l)-2 < 0 || len(l)-2 >= 0 && n > l[len(l)-2] {
				l[len(l)-1] = n
			}
			s.s[i] = l
		}
	}
	if ok {
		// fmt.Printf("%v ?? %v \n", n, s.s)
		s.s = append(s.s, []int{n})
	}
}
func (s *state) Res() int {
	max := 0
	for _, l := range s.s {
		if len(l) > max {
			max = len(l)
		}
	}
	return max
}
func lengthOfLIS(nums []int) int {
	if len(nums) <= 1 {
		return len(nums)
	}
	s := &state{}

	for i, n := range nums {
		if i == 0 {
			s = &state{s: [][]int{{n}}}
			continue
		}
		s.Add(n)

	}
	ans := s.Res()
	// fmt.Printf("%v\n", s)
	return ans
}

