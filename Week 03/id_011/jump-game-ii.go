package algorithm00401

func jump(nums []int) int {
	step := 0

	position := len(nums) - 1
	for position != 0 {
		for i := 0; i < position; i++ {
			if nums[i] >= position-i {
				position = i
				step++
				break
			}
		}
	}
	return step
}
