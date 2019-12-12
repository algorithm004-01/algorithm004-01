package week07

// 1.1 https://leetcode-cn.com/problems/number-of-1-bits/
func hammingWeight(num uint32) int {

	res := 0

	for num != 0 {
		res += int(num % 2) 
		num /= 2
	}
	return res
}