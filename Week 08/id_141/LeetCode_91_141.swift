//
//  LengthOfLIS.swift
//  algorithm
//
//  Created by pingan on 2019/12/5.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation

class LengthOfLIS {
    func lengthOfLIS(_ nums: [Int]) -> Int {
        if nums.count == 0 {
            return 0;
        }
        var dp: [Int] = Array(repeating: 1, count: nums.count);
        var res = 0;
        
        for i in 0..<nums.count {
            for j in 0..<i {
                if nums[j] < nums[i] {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
}
