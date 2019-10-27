package algorithm00401

// 对撞指针解法
func twoSum2(numbers []int, target int) []int {
	l, r := 0, len(numbers)-1
	for l < r {
		if numbers[l]+numbers[r] == target {
			return []int{l, r}
		} else if numbers[l]+numbers[r] > target {
			r--
		} else {
			l++
		}
	}
	return nil
}

// hash 解法
func twoSum(numbers []int, target int) []int {
	memo := make(map[int]int)
	for i := 0; i < len(numbers); i++ {
		sub := target - nums[i]
		if j, ok := memo[sub]; ok {
			return []int{j, i}
		} else {
			memo[nums[i]] = i
		}
	}
	return nil
}
