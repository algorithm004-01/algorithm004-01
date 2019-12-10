//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit
class Solution {
    func reverseWords(_ s: String) -> String {
        var array = s.components(separatedBy: " ")
        array = array.map { (str) -> String in
            return String(str.reversed())
        }
        return array.joined(separator: " ")
    }
}
