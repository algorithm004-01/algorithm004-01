//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit

class Solution {
    var set: UnionSetInt!
    func findCircleNum(_ M: [[Int]]) -> Int {
        if M.count == 0 {
            return 0
        }

        if M.count == 1 {
            return 1
        }

        set =  UnionSetInt(M.count)
        
        for y in 0..<M.count-1 {
            let row = M[y]
            for x in y+1..<row.count {
                if M[y][x] == 1 {
                    set.join(x, y)
                }
            }
        }
        
        return set.rootCount()
    }
}

class UnionSetInt {
    var array = [Int]()
    
    init(_ lenght: Int) {
        for i in 0..<lenght {
            array.append(i)
        }
    }
    
    /// 返回根节点的位置
    func find(_ value: Int) -> Int {
        var position = value
        while array[position] != position {
            position = array[position]
            array[position] = array[array[position]]
        }
        return position
    }
    
    func join(_ x: Int, _ y: Int) {
        let xRoot = find(x)
        let yRoot = find(y)
        if xRoot != yRoot {
           array[yRoot] = xRoot //array[y] -> x ，表示把y的父节点指向了x
        }
    }
    
    func rootCount() -> Int{
        var count = 0
        for i in 0..<array.count {
            if array[i] == i {
                count += 1
            }
        }
        return count
    }
}
