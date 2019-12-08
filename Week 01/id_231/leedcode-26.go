package lessions

func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	cur := 0
	for i := 1; i < len(nums); i++ {
		if nums[cur] == nums[i] {
			continue
		}
		nums[cur+1] = nums[i]
		cur = cur + 1
	}

	return cur + 1
}
