//
//  DecodeWays.swift
//  algorithm
//
//  Created by pingan on 2019/12/5.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation

class DecodeWays {
    func numDecodings(_ s: String) -> Int {
        if s.count == 0 {
            return 0;
        }
        let len = s.count;
        var dp = Array(repeating: 0, count: len + 1);
        dp[len] = 1;
        let arr = Array(s);
        if arr[len - 1] == "0" {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        if len < 2 {
            return arr.first == "0" ? 0 : 1;
        }
        for i in (0...len-2).reversed() {
            if arr[i] == "0" {
                dp[i] = 0;
                continue;
            }
            if Int(String(arr[i]))! * 10 + Int(String(arr[i + 1]))! <= 26 {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
