package week01/id_071

// array https://leetcode-cn.com/problems/two-sum/
func twoSumes(nums []int, target int) []int {

	var new []int
	if len(nums) < 2{
		return new
	}

	for i := 0; i < len(nums); i++ {
		for j := i+1; j < len(nums); j++ {
			if nums[i] + nums[j] == target {
				new = []int{i,j}
				break
			}
		}
	}
	return new
}

//map key => nums values; value => nums key
func twoSum(nums []int, target int) []int {

	mp := make(map[int]int)
	for i, v := range nums {
		if idx,ok := mp[target - v]; ok {
			return []int{idx,i}
		}
		mp[v] = i
	}
	return nil
}