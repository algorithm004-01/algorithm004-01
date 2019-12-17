/*
 26. 删除排序数组中的重复项

 1、注意判空。
 2、快慢指针法，当快慢指针指向的值不同的时候，慢指针指向的值存储快指针指向的值。
*/
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if nums.count == 0 {
            return 0
        }
        
        var i = 0
        for j in 1..<nums.count {
            if nums[j] != nums[i] {
                i += 1
                nums[i] = nums[j]
            }
        }
        return i + 1
    }
}
