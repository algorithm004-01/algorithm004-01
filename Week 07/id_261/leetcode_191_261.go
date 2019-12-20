// leetcode : https://leetcode-cn.com/problems/number-of-1-bits/

func hammingWeight(num uint32) int {
    c := 0
    for num > 0 {
        num &= (num - 1)
        c++
    }
    return c
}