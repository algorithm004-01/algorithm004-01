//
//  RemoveDuplicatesFromSortedArray.swift
//  algorithm
//
//  Created by pingan on 2019/10/20.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation

func removeDuplicates(nums: inout [Int] ) -> Int {
    if nums.count == 0 {
        return 0
    }
    var i: Int = 0
    for j in i+1..<nums.count {
        if nums[i] != nums[j] {
            i += 1
            nums[i] = nums[j]
        }
    }
    return i + 1
}
