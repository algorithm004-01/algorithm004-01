// leetcode - https://leetcode-cn.com/problems/rotate-array/

func reverse(nums []int) {
    for i:= 0; i < int(len(nums) / 2); i++ {
        nums[i],  nums[len(nums) - i - 1] = nums[len(nums) - i - 1], nums[i]
    }
}

func rotate(nums []int, k int)  {
    k = k % len(nums)
    reverse(nums)
    reverse(nums[0: k])
    reverse(nums[k: len(nums)])
}