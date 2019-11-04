package id_716

// https://leetcode-cn.com/problems/climbing-stairs
// 爬楼梯

// 1. 递归
// 1.1 这个实现复杂度太高，指数级增长，超出了时间限制，具体的时间复杂度分析可以尝试思考
func climbStairs11(n int) int {
    if n <= 2 { return n }
    return climbStairs11(n - 1) + climbStairs11(n - 2)
}

// 1.2 尾递归优化，降低时间复杂度
func climbStairs12(n int) int {
    return tailClimbStairs(n, 2, 1)
}

// 这个函数很重要，借助这个函数实现了尾递归调用
func tailClimbStairs(n, oneStepBefore, towStepsBefore int) int {
    if n <= 0 { 
        return 0
    } else if n <= 2 {
        return n
    } else if n == 3 {
        return oneStepBefore + towStepsBefore
    } else {
        // 这里的函数调用是最后一个，而且没有其他上下文数据（如内部变量、调用位置等），所以可以不用保存当前调用的调用栈
        // 调用栈一直可以只保留一个
        return tailClimbStairs(n - 1, oneStepBefore + towStepsBefore, oneStepBefore)
    }
}

// 2. 迭代法
func climbStairs2(n int) int {
    if n <= 2 { return n }
    
    twoStepsBefore := 1
    oneStepBefore := 2
    totalWays := 0
    for i := 3; i <= n; i++ {
        totalWays = twoStepsBefore + oneStepBefore
        twoStepsBefore = oneStepBefore
        oneStepBefore = totalWays
    }
    
    return totalWays
}

// 3. 菲波那切数列公式，这个需要一些数学基础，就先 ignore 了，当然这个方式也是很好的
// 时间复杂度降低了不少，尤其是n很大的时候