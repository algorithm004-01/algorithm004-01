package algorithm00401

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	sr := []rune(s)
	tr := []rune(t)

	counter := make([]rune, 26, 26)
	for i := 0; i < len(sr); i++ {
		counter[sr[i]-'a']++
		counter[tr[i]-'a']--
	}

	for i := 0; i < len(counter); i++ {
		if counter[i] != 0 {
			return false
		}
	}
	return true
}
