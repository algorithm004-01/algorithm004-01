package id_716

// https://leetcode-cn.com/problems/plus-one/

// 1. 模拟进位
func plusOne(digits []int) []int {
    length := len(digits)
    
    // 从后向前
    for i := length - 1; i >= 0; i-- {
        digits[i]++
        digits[i] = digits[i] % 10
        
        if digits[i] != 0 { 
            return digits 
        }
    }
    return append([]int{1}, digits...)
}
