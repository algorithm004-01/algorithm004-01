//
//  LeetCode_64_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit

class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        if grid.count == 0 {
            return 0
        }
        // 找最的重复子问题 min[0,0] = min(min[0,1], min[1,0])。
        // 定义状态数组 a[i][j]
        // DP方程 min[i][j] = mi(min[i][j-1], min[i-1][j]) + grid[i][j]

        var pathSum: [[Int]] = Array(repeating: Array(repeating: 0, count: grid.last!.count), count: grid.count)
        for i in 0..<grid.count {
            let row = grid[i]
            for j in 0..<row.count {
                if i == 0, j == 0 {
                    pathSum[i][j] = grid[i][j]
                } else if i == 0 {
                    pathSum[i][j] = pathSum[i][j-1] + grid[i][j]
                } else if j == 0 {
                    pathSum[i][j] = pathSum[i-1][j] + grid[i][j]
                } else {
                    pathSum[i][j] = min(pathSum[i-1][j],pathSum[i][j-1]) + grid[i][j]
                }
            }
        }
        return pathSum.last!.last!
    }
}
