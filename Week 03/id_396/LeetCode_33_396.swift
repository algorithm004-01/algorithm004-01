//
//  LeetCode_242_396.swift
//  
//
//  Created by chenjunzhi on 2019/10/27.
//


import UIKit

// 搜索旋转排序数组
class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        
        var left = 0
        var right = nums.count - 1
        var result = -1
        while left <= right {
            let mid = right - (right - left) / 2
            if target == nums[mid] {
                return mid
            }
            
            if target == nums[left] {
                return left
            }
            
            if target == nums[right] {
                return right
            }
            
            if nums[left] < nums[mid] {
                if target < nums[mid] && target > nums[left] {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if target < nums[right] && target > nums[mid] {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return result;
    }

}
