class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        // Boyer - Moore 摩尔投票算法
        // 默认 target 计数，非 target 减数，减到 0 重新制定 target。
        // 如果一定存在过半的众数，一定是 target，or 遍历下 target 次数是否过半
        var target = nums[0]
        var count = 1
        
        for num in nums {
            if num != target {
                count -= 1
                if count == 0 {
                    target = num
                    count = 1
                }
            } else {
                count += 1
            }
        }
        
        return target
    }
}
