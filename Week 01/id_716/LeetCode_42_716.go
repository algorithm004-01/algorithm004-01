package id_716

// https://leetcode-cn.com/problems/trapping-rain-water

// 1. 暴力法，遍历找左右边界
func trap1(height []int) int {
    
    length := len(height)
    res := 0
    
    for i := 1; i < length; i++ {
        maxLeft, maxRight := 0, 0
        // 找左边最大高度
        for j := i; j >= 0; j-- {
            maxLeft = max(maxLeft, height[j])
        }
        // 找右边最大最大高度
        for j := i; j < length; j++ {
            maxRight = max(maxRight, height[j])
        }
        // 计算每个柱子能贡献的雨水
        res += min(maxLeft, maxRight) - height[i]
    }
    
    return res
}

func min(m, n int) int {
    if m <= n {
        return m
    }
    return n
}

func max(m, n int) int {
    if m >= n {
        return m
    }
    return n
}

// 2. 双指针，向中间缩进
func trap(height []int) int {
    length := len(height)
    res := 0
    left, right := 0, length - 1
    leftMax, rightMax := 0, 0
    
    for left < right {
        if height[left] <= height[right] {
            // 找左边是否有比他大的，有的话，就可以贡献雨水，因为右边已经比它高了
            if leftMax > height[left] {
                res += (leftMax - height[left])
            } else {
                // 更新左边的最大值
                leftMax = height[left]
            }
            left++
        } else {
            // 找右边是否有比他大的，有的话，就可以贡献雨水，因为左边已经比它高了
            if rightMax > height[right] {
                res += (rightMax - height[right])
            } else {
                rightMax = height[right]
            }
            right--
        }
    }
    
    return res
}