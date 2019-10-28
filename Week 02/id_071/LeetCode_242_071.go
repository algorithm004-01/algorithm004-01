package week02

//1.1 https://leetcode-cn.com/problems/valid-anagram/description/
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	var counter = make(map[byte]int8)

	for i, v :=range s {

		counter[byte(v)]++
		counter[byte(t[i])]--
	}
	for _, val := range counter {
		
		if val != 0 {
			return false
		}
	}

	return true
}