
// 两数之和


/// 解法1 使用HashMap
/// 时间复杂度是O(n) 空间复杂度 O(n)
class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int]{
        var digitalDic : [Int:Int] = [:]
        for (index, value) in nums.enumerated() {
            if let matchIndex = digitalDic[target-value] {
                return [matchIndex, index]
            }
            digitalDic[value] = index
        }
        return [0, 0]
    }
}


/// 解法2 暴力解法
/// 时间复杂度 O(n2) 空间复杂度 O(1)
class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        if (nums.count <= 1) {
            return []
        }
        
        let last = nums.count - 1
        for i in 0..<last {
            let start = i + 1
            let value = target - nums[i]
            for j in start..<nums.count {
                if nums[j] == value {
                    return [i,j]
                }
            }
        }
        return []
    }
}
