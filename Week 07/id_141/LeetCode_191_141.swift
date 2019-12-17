//
//  HammingWeight.swift
//  algorithm
//
//  Created by pingan on 2019/11/28.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation
//191. 位1的个数
class HammingWeight {
    func hammingWeight(_ n: Int) -> Int {
        var count = 0;
        var m = n;
        while m != 0 {
            m = m & (m - 1);
            count += 1;
        }
        return count;
    }
}
