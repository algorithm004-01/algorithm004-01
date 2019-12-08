//
//  LeetCode_242_396.swift
//  
//
//  Created by chenjunzhi on 2019/10/27.
//

import UIKit

class Solution {
    
    /// 思路：把每个字母变成Unicode编码。利用桶的思想，计算每个字符显示的次数。最后比较两个桶是否一样
    func isAnagram(_ s: String, _ t: String) -> Bool {
        guard s.count == t.count else { return false }
        
        let aUnicode = UnicodeScalar("a").value
        
        var counterS = Array(repeating: 0, count: 26)
        for c in s.unicodeScalars {
            counterS[Int(c.value - aUnicode)] += 1
        }
        
        var counterT = Array(repeating: 0, count: 26)
        for c in t.unicodeScalars {
            counterT[Int(c.value - aUnicode)] += 1
        }
        
        return counterS == counterT
    }
    
    /// 把每个字母根据Ascii码进行桶排序，然后比较两个字符串是否相等
    class Solution1 {
        func isAnagram(_ s: String, _ t: String) -> Bool {
            let charS = sort(Array(s))
            let charT = sort(Array(t))
            return charT == charS
        }
        
         func sort(_ chars: [Character]) -> String {
            let charVal = Character("a").asciiValue!
            var buckets = Array(repeating: 0, count: 26)
            for char in chars {
                let index = char.asciiValue! - charVal
                buckets[Int(index)] += 1
            }
            var result = [Character]()
            for index in 0..<buckets.count {
                let count = buckets[index]
                for _ in 0..<count {
                    result.append(Character(UnicodeScalar(index + Int(charVal))!))
                }
            }
            return String(result)
        }
    }
    
    class Solution2 {
        func isAnagram(_ s: String, _ t: String) -> Bool {
            var dicS = [Character: Int]()
            if s.count != t.count {
                return false
            }
            
            for sChar in s {
                if let count = dicS[sChar] {
                    dicS[sChar] = count + 1
                } else {
                    dicS[sChar] = 1
                }
            }
            for tChar in t {
                if let count = dicS[tChar] {
                    if count == 0 {
                        return false;
                    }
                    dicS[tChar] = count - 1
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
