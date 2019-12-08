//
//  LeetCode_221_396.swift
//  
//
//  Created by chenjunzhi on 2019/11/17.
//

import UIKit

class Solution {
    func merge(_ intervals: [[Int]]) -> [[Int]] {
        //先按第一个数排序
        var sortIntervals = intervals
        sort(&sortIntervals, left: 0, right: sortIntervals.count - 1)
        
        var result = [[Int]]()
        //遍历数组，合并区间
        var lastInterval: [Int]?;
        for interval in sortIntervals {
            guard let lastInter = lastInterval else {
                lastInterval = interval
                continue
            }
            //两个不连接
            
            if (lastInter[1] < interval[0]){
                result.append(lastInter)
                lastInterval = interval
            //两个区间有交集
            } else if (lastInter[1] < interval[1]) {
                lastInterval![1] = interval[1]
            } else if(lastInter[1] >= interval[1]) {  //后面的被前面的包含,继续判断下个元素
                    //大于不做任何操作
            }
        }
        
        if let last = lastInterval {
            result.append(last)
        }
        return result;
    }
    
    func sort(_ intervals: inout [[Int]], left: Int, right: Int){
        if (left < right) {
            let middle = quickSort(&intervals, left: left, right: right)
            sort(&intervals, left: left, right: middle - 1)
            sort(&intervals, left: middle + 1, right: right)
        }
    }
    
    //返回中间那个数值
    func quickSort(_ intervals :inout [[Int]],left: Int, right: Int) -> Int {
        
        var base = intervals[left]
        
        //从左边到右边
        var low = left
        var high = right
        while low < high {
            //基准值和最后的比较
            while low < high , base[0] <= intervals[high][0] {
                high = high - 1
            }
            
            intervals[low] = intervals[high] //此时high就空出一个位置
            
            //此时基准值应该处于后半部分
            while low < high , base[0] >= intervals[low][0] {
                low = low + 1
            }
            
            intervals[high] = intervals[low]
        }
        
        intervals[low] = base
        
        return low;
    }
}
