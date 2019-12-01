package algorithm00401

func numDecodings(s string) int {
	if len(s) == 0 || s[:1] == "0" {
		return 0
	}
	a, b := 1, 1
	for i := 1; i < len(s); i++ {
		if s[i:i+1] == "0" {
			a = 0
		}
		if s[i-1:i] == "1" || (s[i-1:i] == "2" && s[i:i+1] <= "6") {
			a = a + b
			b = a - b
		} else {
			b = a
		}
	}
	return a
}
