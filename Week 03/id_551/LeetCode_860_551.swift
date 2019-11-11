class Solution {
    func lemonadeChange(_ bills: [Int]) -> Bool {
        // 贪心算法
        
        // 贪心法前提：20 % 5，10 % 5 均为 0，所以子问题实现局部最优解，可以获得最终结果最优
       
        /* 局部最优解：
        1、5 元不需要找零；
        2、10 元, 如果有 5 元则找零 5 元;
        3、20 元，如果有 10 元和 5元，则找零 10 元和 5 元，或者 3 个 5元；
        */
        var ten: Int = 0
        var five: Int = 0
        
        for bill in bills {
            if bill == 5 {
                five += 1
            } else if bill == 10 {
                if five > 0 {
                    ten += 1
                    five -= 1
                } else {
                    return false
                }
            } else if bill == 20 {
                if ten > 0 && five > 0 {
                    ten -= 1
                    five -= 1
                } else if five > 2 {
                    five -= 3
                } else {
                    return false
                }
            }
        }
        
        return true
    }
}
