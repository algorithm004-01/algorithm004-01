package id_531

//IsAnagram t是否s是字母异位词
func IsAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	sr := []rune(s)
	tr := []rune(t)
	m := make(map[rune]int, 0)
	for i := range sr {
		m[sr[i]]++
		m[tr[i]]--
	}
	for _, v := range m {
		if v != 0 {
			return false
		}
	}
	return true
}
