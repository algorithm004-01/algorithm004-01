package algorithm00401

func isIsomorphic(s string, t string) bool {
	m1 := make([]int, 256)
	m2 := make([]int, 256)

	for i := 0; i < len(s); i++ {
		if m1[s[i]-'a'] != m2[t[i]-'a'] {
			return false
		}

		m1[s[i]-'a'] = i + 1
		m2[t[i]-'a'] = i + 1
	}

	return true
}
