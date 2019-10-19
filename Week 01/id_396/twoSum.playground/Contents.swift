import UIKit

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
