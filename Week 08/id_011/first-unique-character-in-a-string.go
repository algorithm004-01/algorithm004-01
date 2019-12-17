package algorithm00401

func firstUniqChar(s string) int {
	var memo [26]int
	for _, c := range s {
		memo[c-'a']++
	}
	for i, c := range s {
		if memo[c-'a'] == 1 {
			return i
		}
	}
	return -1
}
