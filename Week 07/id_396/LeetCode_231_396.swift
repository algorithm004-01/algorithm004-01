//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit

//231 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
class Solution {
    func isPowerOfTwo(_ n: Int) -> Bool {
        return n & (n - 1) == 0
    }
}

