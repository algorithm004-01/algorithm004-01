//
//  TwoSum.swift
//  algorithm
//
//  Created by pingan on 2019/10/16.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation

//func twoSum(nums: [Int],target: Int) -> [Int] {
//    for i in 0..<nums.count - 1 {
//        for j in i+1..<nums.count {
//            if nums[i] + nums[j] == target {
//                return [i,j]
//            }
//        }
//    }
//    return []
//}

//func twoSum(nums: [Int], target: Int) -> [Int] {
//    var dic: [Int: Int] = [Int: Int]()
//    for i in 0..<nums.count {
//        dic[nums[i]] = i
//    }
//    for i in 0..<nums.count {
//        let value = target - nums[i]
//        if dic.keys.contains(value) && dic[value] != i {
//            return [i,dic[value]!]
//        }
//    }
//    return []
//}

func twoSum(nums: [Int], target: Int) -> [Int] {
    var dic: [Int: Int] = [Int: Int]()
    for i in 0..<nums.count {
        let value = target - nums[i]
        if dic.keys.contains(value) {
            return [i, dic[value]!]
        }
        dic[nums[i]] = i
    }
    return []
}
