package algorithm00401

func splitArray(nums []int, m int) int {
	l, r := 0, 0
	for i := 0; i < len(nums); i++ {
		r += nums[i]
		if l < nums[i] {
			l = nums[i]
		}
	}
	ans := r
	for l <= r {
		mid := l + (r-l)/2
		sum, cnt := 0, 1
		for i := 0; i < len(nums); i++ {
			if sum+nums[i] > mid {
				cnt++
				sum = nums[i]
			} else {
				sum += nums[i]
			}
		}
		if cnt <= m {
			ans = minInt(ans, mid)
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return ans
}

func minInt(i, j int) int {
	if i < j {
		return i
	}
	return j
}
