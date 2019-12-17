// leetcode - https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array

func findMin(nums []int) int {
    left, right := 0, len(nums) - 1
    for left < right {
        mid := (left + right) / 2
        if nums[mid] < nums[right] {
            right = mid
        } else if nums[mid] > nums[right] && right - mid == 1 {
            return nums[right]
        } else {
            left = mid
        }
    }
    return nums[0]
}