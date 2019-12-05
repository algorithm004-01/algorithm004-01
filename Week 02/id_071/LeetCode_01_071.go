package week02


// 1.2 https://leetcode-cn.com/problems/two-sum/
func twoSum(nums []int, target int) []int {

	var mp = map[int]int{}
	for i := 0;i < len(nums); i++ {
		if index, ok := mp[target-nums[i]]; ok {
			return []int{index,i}
		}
		mp[nums[i]] = i
	}
	return nil
}