//
//  PowerOfTwo.swift
//  algorithm
//
//  Created by pingan on 2019/11/28.
//  Copyright © 2019 pingan. All rights reserved.
//

import Foundation
//231. 2的幂
class PowerOfTwo {
    func powerOfTwo(_ n: Int) -> Bool {
        return n != 0 && (n & (n - 1)) == 0;
    }
}
