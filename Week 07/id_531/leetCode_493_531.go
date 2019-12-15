package id_531

func reversePairs(nums []int) int {
	return mergeSort(nums, 0, len(nums)-1)
}

func mergeSort(nums []int, left, right int) int {
	if left >= right {
		return 0
	}
	mid := left + (right-left)/2
	count := mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right)
	cache := make([]int, right-left+1)
	i := left
	t := left
	c := 0
	for j := mid + 1; j < right; j++ {
		for i <= mid && nums[i] <= 2*nums[j] {
			i++
		}
		for t <= mid && nums[t] < nums[j] {
			c++
			t++
			cache[c] = nums[t]
		}
		cache[c] = nums[j]
		count += mid - i + 1
		c++
	}
	for t <= mid {
		c++
		t++
		cache[c] = nums[t]
	}
	copy(nums, cache)
	return count
}
