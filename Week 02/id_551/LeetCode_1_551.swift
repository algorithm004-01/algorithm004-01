class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        // 利用特性：map key 不重复
        // rtype: [Int]  index
        // value: index
        var dic = [Int:Int]()
        for (index, value) in nums.enumerated() {
            if let complementIndex = dic[target - value] {
                return [index, complementIndex]
            }
            dic[value] = index
        }
        return []
    }
}
