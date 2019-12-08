package week02

// 3.2 https://leetcode-cn.com/problems/permutations/
func permute(nums []int) [][]int {

	output := [][]int{}

	backtrack(&output,0,nums)

	return output
}

func backtrack(output  *[][]int, idx int, nums []int)  {

	if idx == len(nums) {
		c := make([]int, len(nums))
		copy(c, nums)
		*output = append(*output, c)
		return 
	}
	for i := idx; i < len(nums); i++ {
		nums[idx], nums[i] = nums[i], nums[idx]
		backtrack(output, idx + 1, nums)
		nums[i], nums[idx] = nums[idx], nums[i]
	}
}