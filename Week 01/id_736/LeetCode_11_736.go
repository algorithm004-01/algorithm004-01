package id_736

func Min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func Max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
func maxArea(height []int) int {
	//brute force O(n^2)
	//right := len(height)
	//maxValue := -1
	//for i := 1; i <= right-1; i++ {
	//	for j := i + 1; j <= right; j ++ {
	//		sum := ( j - i ) * Min(height[i-1], height[j-1])
	//		if maxValue < sum {
	//			maxValue = sum
	//		}
	//	}
	//}
	//return maxValue

	arrayLen := len(height)
	result := -1
	left := 0
	right := arrayLen-1
	for left < right {
		result = Max(result, ( right - left ) * Min(height[right], height[left]))
		if height[right] < height[left] {
			right = right - 1
		} else {
			left = left + 1
		}
	}
	return result
}