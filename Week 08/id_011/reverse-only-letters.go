package algorithm00401

func reverseOnlyLetters(S string) string {
	b := []byte(S)

	for l, r := 0, len(b)-1; l < r; {
		for l < r && !isBetter(b[l]) {
			l++
		}
		for l < r && !isBetter(b[r]) {
			r--
		}
		b[l], b[r] = b[r], b[l]
		l++
		r--
	}

	return string(b)
}

func isBetter(b byte) bool {
	return (b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z')
}
