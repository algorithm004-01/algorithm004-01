package algorithm00401

func hammingWeight(num unint32) int {
	sum := 0
	for num != 0 {
		sum++
		num &= (num - 1)
	}
	return sum
}
