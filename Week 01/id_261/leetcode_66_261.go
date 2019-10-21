// leetcode - https://leetcode-cn.com/problems/plus-one/

func plusOne(digits []int) []int {
    result := make([]int, len(digits) + 1)
    digits[len(digits) - 1]++
    for i, j := len(digits)-1, len(digits); i >= 0; i,j = i-1, j-1 {
        a := int((result[j] + digits[i]) / 10)
        result[j] = (result[j] + digits[i]) % 10
        result[j - 1] = a
    }
    if result[0] == 0 {
        return result[1:]
    }
    return result
}