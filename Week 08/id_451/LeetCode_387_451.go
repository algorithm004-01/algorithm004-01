func firstUniqChar(s string) int {
	m := make(map[int32]int)
	for _, a := range s {
		if c, ok := m[a]; ok {
			m[a] = c + 1
		} else {
			m[a] = 1
		}
	}
	for i, a := range s {
		if m[a] == 1 {
			return i
		}
	}
	return -1
}
