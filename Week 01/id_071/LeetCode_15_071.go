package week01/id_071

import "sort"

// array https://leetcode-cn.com/problems/3sum/
// O(n^2)  new array for 
func threeSumes(nums []int) [][]int {

	var result [][]int
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue //To prevent the repeat
		}
		target,l,r := -nums[i],i+1,len(nums)-1
		for l < r {
			sum := nums[l] + nums[r]
			if sum == target {
				result = append(result,[]int{nums[i],nums[l],nums[r]})
				l++
				r--
				for l < r && nums[l] == nums[l-1]{
					l++
				}
				for l < r && nums[r] == nums[r+1]{
					r--
				}
			}else if sum > target {
				r--
			}else if sum < target {
				l++
			}
		}
	}

	return result
}

// O(nlogn) 排序 双指针
func threeSum(nums []int) [][]int {

	var result [][]int
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {

	}

	return result
}
