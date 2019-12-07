func moveZeroes(nums []int) {
    insert := 0
    for i := 0; i < len(nums); i++ {
        if nums[i] != 0 {
            nums[insert] = nums[i]
            insert++
        }
    }
    for insert < len(nums) {
        nums[insert] = 0
        insert++
    }
}