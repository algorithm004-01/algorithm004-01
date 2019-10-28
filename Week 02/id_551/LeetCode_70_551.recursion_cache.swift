class Solution {
    
    var cache = [Int: Int]()
    func climbStairs(_ n: Int) -> Int {

        if n <= 1 { return 1 }

        if let val = cache[n] {
            return val
        } else {
            cache[n] = climbStairs(n - 1) + climbStairs(n - 2)
            return cache[n]!
        }

    }
    
}
