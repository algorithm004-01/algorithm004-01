package week07

//1.2 https://leetcode-cn.com/problems/power-of-two/
func isPowerOfTwo(n int) bool {

	return n > 0 && n&(n - 1) == 0
}