package id_716

// 1. 快慢指针
// 1.1
func removeDuplicates11(nums []int) int {
	length := len(nums)
	if length <= 1 {
		return length
	}

	// slow ptr, insert position
	insertPos := 1

	for i := 1; i < length; i++ {
		if nums[i] != nums[i-1] {
			nums[insertPos] = nums[i]
			insertPos++
		}
	}

	return insertPos
}

// 1.2 这种解法和 1.1 是一样的思路，但是 for 循环的不同写法，最终导致在leetcode上的执行时间，当前
// 写法快了 4ms，这个留作思考题去研究一下
func removeDuplicates12(nums []int) int {
	length := len(nums)
	if length <= 1 {
		return length
	}

	insertPos := 1
	idx := 1
	for idx < length {
		if nums[idx] != nums[idx-1] {
			nums[insertPos] = nums[idx]
			insertPos++
		}
		idx++
	}

	return insertPos
}

// 2. snowball 解法，和 removeZeroes 其实是类似的题目
func removeDuplicates2(nums []int) int {
	length := len(nums)
	if length <= 1 {
		return length
	}

	// 这里 snowballSize 可以理解为数字的重复数
	snowballSize := 0
	i := 1
	for i < length {
		if nums[i] != nums[i-1] {
			if snowballSize > 0 {
				nums[i - snowballSize] = nums[i]
			}
		} else {
			snowballSize++
		}

		i++
	}

	// 总数减去重复数，就是不重复的数
	return length - snowballSize
}
