class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        // 当成虚拟有序数组处理，二分查找
        // low = 0, high = m * n - 1, mid = low + (high - low) / 2, row_mid = mid / n, clomun_mid = mid % n
        
        var m = matrix.count
        if m == 0 { return false }
        var n = matrix[0].count
        
        var lo = 0
        var hi = m * n - 1
        
        while lo <= hi {
            var mid = (lo + hi) / 2
            var val = matrix[mid / n][mid % n]
            
            if target == val {
                return true
            }
            
            if target > val && target <= matrix[hi / n][hi % n] {
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        
        return false
    }
}
