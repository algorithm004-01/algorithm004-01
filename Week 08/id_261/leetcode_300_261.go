// leetcode : https://leetcode-cn.com/problems/longest-increasing-subsequence

func lengthOfLIS(nums []int) int {
    n := len(nums)
    if n <= 1 {
        return n
    }
    a := make([]int, n)
    a[0] = 1
    maxDP := 1
    for i := 1; i < n; i++ {
        max := 1
        for j:=i-1; j >=0; j-- {
            if nums[i] > nums[j] {
                if max < a[j] + 1 {
                    max = a[j] + 1
                }
            }
        }
        a[i] = max
        if max > maxDP {
            maxDP = max
        }
    }
    return maxDP
}