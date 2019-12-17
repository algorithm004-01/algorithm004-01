package week08

//2.1 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
func firstUniqChar(s string) int {
	if len(s) < 1 {
		return 0
	}
	var m = make(map[string]int)
	for i := 0; i < len(s); i++ {
		m[string(s[i])] ++
	}

	for j := 0; j < len(s); j++ {
		if m[string(s[j])] == 1 {
			return j
		}
	}
    return -1
}