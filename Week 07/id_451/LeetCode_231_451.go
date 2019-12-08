func isPowerOfTwo(n int) bool {
	if n&(n-1) == 0 && n != 0 {
		return true
	}
	return false
}
