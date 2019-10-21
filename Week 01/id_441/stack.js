// 最近相关性的问题  类似于洋葱结构的话  这样的问题都是用栈来解决的。
// 先来后到的话都是采用队列来解决的


// valid-parentheses https://leetcode-cn.com/problems/valid-parentheses/
// 1. 暴力解法 不断replace匹配的括号 ->直到变成-> '' 时间复杂度 O(n^2)
// 2. 利用栈来解决