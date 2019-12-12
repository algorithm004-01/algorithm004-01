package id_736


func rotateArrayBruteForce(nums []int, k int) {
	for i := 0; i < k; i++ {
		move(nums, len(nums)-1)
	}
}

func reverseThreeTimes(nums []int, k, numsLen int) {
	k %= numsLen;
	reverse(nums, 0, numsLen-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, numsLen-1)
}

func rotate(nums []int, k int) {
	// rotateArrayBruteForce(nums, k)
	reverseThreeTimes(nums, k, len(nums))
}

func move(nums []int, numsLen int) []int {
	temp := nums[numsLen]
	for j := numsLen; j > 0; j-- {
		nums[j] = nums[j-1]
	}
	nums[0] = temp
	return nums
}

func reverse(s []int, start, end int) {
	for i, j := start, end; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
}