func lemonadeChange(bills []int) bool {
	sum := make(map[int]int)
	for _, b := range bills {
		switch b {
		case 5:
			sum[5] += 1
		case 10:
			sum[10] += 1
			if sum[5] <= 0 {
				return false
			}
			sum[5] -= 1
		case 20:
			sum[20] += 1
			if sum[10] > 0 && sum[5] > 0 {
				sum[10] -= 1
				sum[5] -= 1
			} else if sum[5] >= 3 {
				sum[5] -= 3
			} else {
				return false
			}
		default:
			panic("never")
		}
	}
	return true
}
