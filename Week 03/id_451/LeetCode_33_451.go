func _search(nums []int, l, r, t int) int {

	if r-l == 0 {
		if nums[r] == t {
			return r
		}
		return -1
	}

	if r-l == 1 {
		if nums[r] == t {
			return r
		}
		if nums[l] == t {
			return l
		}
		return -1
	}
	m := (l + r) / 2
	if nums[l] <= nums[m] && nums[m] < nums[r] {
		if t >= nums[l] && t <= nums[r] {
			if t >= nums[m] {
				return _search(nums, m, r, t)
			}
			return _search(nums, l, m, t)
		}
	}

	a := _search(nums, l, m, t)
	if a != -1 {
		return a
	}
	b := _search(nums, m, r, t)
	if b != -1 {
		return b
	}
	return -1
}
func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}
	return _search(nums, 0, len(nums)-1, target)
}
