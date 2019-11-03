package week02

// 4.1
func majorityElement(nums []int) int {
	max, count := nums[0], 1
	for i := 1; i < len(nums); i++ {
		if nums[i] != max {
			if count > 0 {
				count--
			}else{
				max = nums[i]
				count = 1
			}
		}else{
			count++
		}
	}
	return max
}

func majorityElementes(nums []int) int {

	majorityCount := len(nums)/2
	for _, v := range nums {
		count := 0
		for _, val := range nums {
			if v == val {
				count += 1
			}
		}

		if count > majorityCount {
			return v
		}
	}
	return -1    
}