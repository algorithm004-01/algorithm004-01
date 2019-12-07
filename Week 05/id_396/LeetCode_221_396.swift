//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit

class Solution {
    func maximalSquare(_ matrix: [[Character]]) -> Int {
        // 求最大正方形，可以转为求最大正方形的边长 a[i][j] = min(a[i-1][j], a[i][j-1])
        // 状态 a[i][j]
        // dp dp[i][j] = mix(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
        //
        if matrix.count == 0 {
            return 0
        }

        var lenghts: [[Int]] = Array(repeating: Array(repeating: 0, count: matrix.last!.count+1), count: matrix.count+1)
        var maxLenght = 0;
        for i in 1...matrix.count {
            let row = matrix[i-1]
            for j in 1...row.count {
                if matrix[i-1][j-1] == "1" {
                    lenghts[i][j] = min(min(lenghts[i-1][j], lenghts[i][j-1]), lenghts[i-1][j-1]) + 1
                    maxLenght = maxLenght < lenghts[i][j] ? lenghts[i][j] : maxLenght
                }
            }
        }
        return maxLenght * maxLenght
    }
}
