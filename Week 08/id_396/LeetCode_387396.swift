//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit
class Solution {
    func firstUniqChar(_ s: String) -> Int {
        var chars = Array(s)
        var dic: [Int] = Array(repeating: 0, count: 256)
        for char in s {
            dic[Int(char.asciiValue!)] = dic[Int(char.asciiValue!)] + 1
        }
        
        for i in 0..<s.count {
            
            let char = chars[i]
            if dic[Int(char.asciiValue!)] == 1 {
                return i;
            }
        }
        
        return -1;
    }
}
