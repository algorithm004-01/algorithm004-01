package algorithm00401

func reverseStr(s string, k int) string {
	b := []byte(s)
	for i := 0; i < len(s); i++ {
		j := minInt(i+k, len(s))
		reverse(b[i:j])
	}
	return string(b)
}

func minInt(i, j int) int {
	if i < j {
		return i
	}
	return j
}

func reverse(b []byte) {
	i, j := 0, len(b)-1
	for i < j {
		b[i], b[j] = b[j], b[i]
		i++
		j--
	}
}
