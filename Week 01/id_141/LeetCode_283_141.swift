//
//  MoveZeros.swift
//  algorithm
//
//  Created by pingan on 2019/10/15.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation

//func moveZeros(nums: inout [Int]) {
//    var lastNonZeroIndex: Int = 0
//    for i in 0..<nums.count {
//        if nums[i] != 0 {
//            nums[lastNonZeroIndex] = nums[i]
//            lastNonZeroIndex += 1
//        }
//    }
//    for i in lastNonZeroIndex..<nums.count {
//        nums[i] = 0
//    }
//}

//func moveZeros(nums: inout [Int]) {
//    var zeroCount: Int = 0
//    for i in 0..<nums.count {
//        if nums[i] == 0 {
//            zeroCount += 1
//        }
//    }
//    var tempNums: [Int] = [Int]()
//    for i in 0..<nums.count {
//        if nums[i] != 0 {
//            tempNums.append(nums[i]);
//        }
//    }
//
//    while zeroCount != 0 {
//        tempNums.append(0)
//        zeroCount -= 1
//    }
//    nums = tempNums
//}

func moveZeros(nums: inout [Int]) {
    var zeroCount = 0
    for i in 0..<nums.count {
        if nums[i] == 0 {
            zeroCount += 1
        }else{
            nums[i - zeroCount] = nums[i]
        }
    }
    for i in nums.count - zeroCount..<nums.count {
        nums[i] = 0
    }
}
