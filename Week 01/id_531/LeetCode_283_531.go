package id531

// MoveZeros1 按0 出现的次数挪动
func MoveZeros1(nums []int) {
	zeroCount := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			zeroCount++
		} else {
			if zeroCount > 0 {
				nums[i-zeroCount] = nums[i]
				nums[i] = 0
			}
		}
	}
}

// MoveZeros2 双指针
func MoveZeros2(nums []int)  {
	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[j] = nums[i]
			j++
		}
	}

	for i := j; i < len(nums); i++ {
		nums[i] = 0
	}
}
