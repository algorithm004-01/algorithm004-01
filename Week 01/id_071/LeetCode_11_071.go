package week01/id_071

// array  https://leetcode-cn.com/problems/container-with-most-water/
func maxAreaes(height []int) int {

	if len(height) < 2 {
		return 0
	}

	if len(height) == 2 {
		if height[0] > height[1]{
			return height[0]
		}

		return height[1]
	}

	var (
		min int
		max int
		temp int
	)

	for i := 0;i < len(height); i++ {
		for j := i+1; j < len(height); j++ {
			if height[i] > height[j]{
				min = height[j]
			}
			min = height[i]
			temp = (j-i)*min
			if max < temp {
				max = temp
			}
		}
	}

	return max
}

func maxArea(height []int) int {

	if len(height) < 2 {
		return 0
	}

	if len(height) == 2{
		if height[0] > height[1]{
			return height[0]
		}
		return height[1]
	}

	var (
		min int
		temp int
		num int
		max = len(height)-1
	)

	for min < max {
		if height[min] < height[max]{
			temp = height[min]
		}
		temp = height[max]
		if (max - min)*temp > num {
			num = (max - min)*temp
		}
		if height[min] < height[max] {
			min++
		}else{
			max--
		}
	}

	return num
}