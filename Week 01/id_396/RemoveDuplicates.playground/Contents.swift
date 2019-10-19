import UIKit

func removeDuplicates(_ nums: inout [Int]) -> Int {
    if nums.count <= 1 {
        return nums.count
    }
    
    var lastIndex = 0;
    for i in 1..<nums.count {
        if (nums[lastIndex] != nums[i]) {
            nums[lastIndex + 1] = nums[i]
            lastIndex += 1
        }
    }
    return lastIndex + 1;
}

