//
//  LeetCode_242_396.swift
//  
//
//  Created by chenjunzhi on 2019/10/27.
//


import UIKit

// 寻找旋转排序数组中的最小值
class Solution {
    func findMin(_ nums: [Int]) -> Int {
        if(nums.first! < nums.last!) {
            return nums.first!
        }
        
        var left = 0
        var right = nums.count - 1
        while left < right-1 {
            let mid = right - (right - left) / 2
            if nums[left] > nums[mid] { //无序在左右，所以最小的点的左边
                right = mid //不能为mid-1 因为有可能mid就是最小的点
            } else {
                left = mid
            }
        }
        return nums[right]
    }
}
