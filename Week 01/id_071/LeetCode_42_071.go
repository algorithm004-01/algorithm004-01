package week01/id_071

func trap(height []int) int {

	if len(height) == 0 {
		return 0
	}

	var max,maxIndex int
	for i, h := range height {
		if h > max {
			max = h
			maxIndex = i
		}
	}
	var total, leftMax, rightMax int 
	for i := 0; i < maxIndex; i++ {
		if leftMax < height[i]{
			leftMax = height[i]
		}
		total += leftMax - height[i]
	}

	for i := len(height)-1; i > maxIndex; i-- {
		if rightMax < height[i]{
			rightMax = height[i]
		}
		total += rightMax - height[i]
	}
	return total
}