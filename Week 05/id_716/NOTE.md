# NOTE

## 动态规划笔记

分治、递归、动态规划本质上是一样的。

- 误区

1. 人肉递归低效，很累，一定不要做人肉递归
2. 找到最近最简方法，将其拆解成可重复解决的问题；复杂的大问题肯定可以拆解成更小的多个子问题
3. 使用数学归纳法思维，抵制人肉递归；比如n=1，n=2时的情况，n和n+1之间的关系等
4. 本质：寻找重复性，转变成计算机指令集（if-else，loop，递归等）
5. 如果想要体验一下递归的话，画递归状态树

- 动态规划

动态规划的定义：[wiki Dynamic programming](https://en.wikipedia.org/wiki/Dynamic_programming)。把复杂的问题分解成简单的子问题，一般是采用递归的方式。等价于分治+最优子结构。

可以理解为动态递推。动态规划和分治或者递归没有根本性区别，关键看有无最优的子结构。共性是找到重复子问题。差异是最优子结构，中途可以淘汰次优解。

- 题目

1. Fibonacci 数列
2. 路径计数 count the path  <https://leetcode-cn.com/problems/unique-paths/>  (done)
3. 路径计数II <https://leetcode-cn.com/problems/unique-paths-ii/> (done)
4. 最长公共子序列题目 <https://leetcode-cn.com/problems/longest-common-subsequence/>
5. <https://leetcode-cn.com/problems/climbing-stairs/description/>  如果可以走1，2，3步，该怎么解决；如果是相邻的两步不能相同，如何解决？
6. <https://leetcode-cn.com/problems/triangle/description/>
7. <https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)>
8. <https://leetcode-cn.com/problems/maximum-subarray/>
9. <https://leetcode-cn.com/problems/maximum-product-subarray/description/>
10. <https://leetcode-cn.com/problems/coin-change/description/>
11. https://leetcode-cn.com/problems/house-robber/
https://leetcode-cn.com/problems/house-robber-ii/description/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/

高级DP题目：

https://leetcode-cn.com/problems/perfect-squares/
https://leetcode-cn.com/problems/edit-distance/ （重点）
https://leetcode-cn.com/problems/jump-game/
https://leetcode-cn.com/problems/jump-game-ii/
https://leetcode-cn.com/problems/unique-paths/
https://leetcode-cn.com/problems/unique-paths-ii/
https://leetcode-cn.com/problems/unique-paths-iii/
https://leetcode-cn.com/problems/coin-change/
https://leetcode-cn.com/problems/coin-change-2/

作业：

https://leetcode-cn.com/problems/longest-valid-parentheses/
https://leetcode-cn.com/problems/minimum-path-sum/
https://leetcode-cn.com/problems/edit-distance/
https://leetcode-cn.com/problems/decode-ways
https://leetcode-cn.com/problems/maximal-square/
https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
https://leetcode-cn.com/problems/frog-jump/
https://leetcode-cn.com/problems/split-array-largest-sum
https://leetcode-cn.com/problems/student-attendance-record-ii/
https://leetcode-cn.com/problems/task-scheduler/
https://leetcode-cn.com/problems/palindromic-substrings/
https://leetcode-cn.com/problems/minimum-window-substring/
https://leetcode-cn.com/problems/burst-balloons/

---

## 总结

### 【716-Week 05】分治、回溯、贪心和动态规划

todo
