

/// 数组加1: 模仿数学加法运算
/// 在这个题，有可能会想到把数组转为数字再计算+1,最后再转回来数组。这个方法得要有个条件：转换成为数字不能水溢出
class Solution {
    func plusOne(_ digits: [Int]) -> [Int] {
        var digits = digits;
        var isPlusOne = true;
        for i in (0..<digits.count).reversed() {
            let addNum = isPlusOne ? 1 : 0;
            let result = digits[i] + addNum
            digits[i] = result % 10
            if result >= 10 {
                isPlusOne = true
            } else {
                isPlusOne = false
                return digits
            }
        }
        if isPlusOne {
            return [1] + digits
        } else {
            return digits
        }
        
    }
}

