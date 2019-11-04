// leetcode - https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

func removeDuplicates(nums []int) int {
    if (len(nums) == 0) {
        return 0
    }
    prev := nums[0]
    index := 1
    for i := 1; i < len(nums); i++ {
        if prev != nums[i] {
            nums[index] = nums[i]
            prev = nums[i]
            index++
        }
    }
    return index
}