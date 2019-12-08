//
//  NumberOfIsland.swift
//  algorithm
//
//  Created by pingan on 2019/11/23.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation
//200. 岛屿数量
class NumberOfIslands
{
    let directions: [[Int]] = [[-1,0],[0,-1],[1,0],[0,1]];
    var marked: [[Bool]]?;
    var rows = 0;
    var cols = 0;
    var grid: [[Character]]?
    func numIslands(_ grid:[[Character]]) -> Int {
        rows = grid.count;
        if rows == 0 {
            return 0;
        }
        cols = grid[0].count;
        self.grid = grid;
        marked = Array(repeating: Array(repeating: false, count: cols), count: rows);
        var count = 0;
        for i in 0..<rows {
            for j in 0..<cols {
                if !marked![i][j] && grid[i][j] == Character("1") {
                    dfs(i,j);
                    count += 1;
                }
            }
        }
        return count;
    }
    func dfs(_ i: Int, _ j: Int) {
        marked![i][j] = true;
        for m in 0..<directions.count {
            let newX = i + directions[m][0];
            let newY = j + directions[m][1];
            if inArea(newX, newY) && grid![newX][newY] == Character("1") && !marked![newX][newY] {
                dfs(newX, newY);
            }
            
        }
    }
    func inArea(_ x: Int, _ y: Int) -> Bool {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
