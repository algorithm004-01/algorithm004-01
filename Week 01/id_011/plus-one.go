package algorithm00401

func plusOne(digits []int) []int {
	for i := len(digits); i >= 0; i-- {
		digits[i]++
		digits[i] %= 10
		if digits[i] != 0 {
			return digits
		}
	}

	digits = make([]int, len(digits)+1)
	digits[0] = 1
	return digits
}
