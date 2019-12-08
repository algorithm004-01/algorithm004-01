//
//  ReverseBits.swift
//  algorithm
//
//  Created by pingan on 2019/11/28.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation
//190. 颠倒二进制位
class ReverseBits {
    func reverseBits(_ n: Int) -> Int {
        var res = 0;
        var m = n;
        for _ in 0..<32 {
            res <<= 1;
            res += m & 1;
            m >>= 1;
        }
        return res;
    }
}
