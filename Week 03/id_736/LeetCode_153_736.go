package id_736

func findMin(nums []int) int {
	l := 0
	r := len(nums)-1
	m := 0
	if len(nums) == 1 {
		return nums[0]
	}

	for l<=r {
		m = l+(r-l)/2
		if m == 0 {
			if nums[0] > nums[1] {
				return nums[1]
			} else {
				return nums[0]
			}
		}
		if nums[m] < nums[m-1] {
			return nums[m]
		} else if nums[m] > nums[0] {
			l = m+1
		} else {
			r = m-1
		}
	}
	return nums[0]
}