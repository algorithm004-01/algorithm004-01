package id_636

/*
	从列表中筛选出两个数字，使得相加等于 Target，
	如果能找到则返回数字的下标 ，找不到则返回空。
	两种办法：
		1：暴力破解，时间复杂度 O(n^2)
		2：使用 map 方法，可以记录已经遍历的数字，一次遍历即可
*/

// 省略暴力方法的代码，直接用第二种
func twoSum(nums []int, target int) []int {
	// 略过判断数组长度的部分， 呃，还是写上吧
	if len(nums) < 2 {
		return []int{}
	}

	// 记录已经存在
	exist := make(map[int]int)

	// 循环遍历数组
	for i := 0; i < len(nums); i++ {
		// index & value
		value := nums[i]
		index := i

		// check
		possibleNum := target - value
		if key, ok := exist[possibleNum]; ok {
			return []int{key, index}
		}
		exist[value] = index
	}
	return []int{}
}