//
//  FriendCircles.swift
//  algorithm
//
//  Created by pingan on 2019/11/23.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation
//547. 朋友圈
class FriendCircle {
    func findCircleNum(_ M: [[Int]]) -> Int {
        var visited: [Int] = Array(repeating: 0, count: M.count);
        var count = 0;
        for i in 0..<M.count {
            if visited[i] == 0 {
                dfs(M, &visited, i);
                count+=1;
            }
        }
        return count;
    }
    func dfs(_ M: [[Int]], _ visited: inout [Int], _ i: Int) {
        for j in 0..<M.count {
            if M[i][j] == 1 && visited[j] == 0{
                visited[j] = 1;
                dfs(M, &visited, j);
            }
        }
    }
}
