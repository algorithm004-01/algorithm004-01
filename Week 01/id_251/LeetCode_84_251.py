# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
#
# 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
#
# 
#
# 
#
# 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
#
# 
#
# 
#
# 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
#
# 
#
# 示例: 
#
# 输入: [2,1,5,6,2,3]
# 输出: 10
# Related Topics 栈 数组

"""
1 暴力解法 两重循环 一个取min操作 O(n*3)
2 遍历一遍 左右边界 O(n^2)
3 栈 O(n) 单调递增栈用来找右边界，找到了就弹出计算
    栈方法是对左右边界方法的改进；
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """

    def largestRectangleArea1(self, heights):
        max_area = 0
        for i in range(len(heights)):
            for j in range(i, len(heights)):
                min_high = min(heights[i: j + 1])
                max_area = max(max_area, min_high * (j - i + 1))
        return max_area

    # 暴力法优化 O(n^2)
    def largestRectangleArea1_1(self, heights):
        max_area = 0
        for i in range(len(heights)):
            min_high = heights[i]
            for j in range(i, len(heights)):
                min_high = min(min_high, heights[j])
                max_area = max(max_area, min_high * (j - i + 1))
        return max_area

    def largestRectangleArea2(self, heights):
        max_area = 0
        for i in range(len(heights)):
            l = r = i
            while l >= 0 and heights[l] >= heights[i]:
                l -= 1
            while r < len(heights) and heights[r] >= heights[i]:
                r += 1
            max_area = max(max_area, heights[i] * (r - l - 1))
        return max_area

    def largestRectangleArea3(self, heights):
        max_area = 0
        stack = [-1]
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[i] < heights[stack[-1]]:
                max_area = max(max_area, heights[stack.pop()] * (i - stack[-1] - 1))
            stack.append(i)
        while stack[-1] != -1:
            max_area = max(max_area, heights[stack.pop()] * (len(heights) - stack[-1] - 1))
        return max_area

    # 栈 优化版
    def largestRectangleArea3_1(self, heights):
        max_area = 0
        """        
        heights.append(0) 这里很巧妙有2点
        1：将第一个while的stack[-1] != -1判断省掉
        因为当stack[-1] == -1时，height[i] > 0, heights[stack[-1]] = heights[-1] = 0
        从而 heights[i] < heights[stack[-1]] 包含 stack[-1= != -1 的判断
        2：讲上一方法的最后for循环提升到前面来实现
        while stack[-1] != -1:
            max_area = max(max_area, heights[stack.pop()] * (len(heights) - stack[-1] - 1))
        当 i 迭代到最后
        正好是 i = 原长度
        最后一次刚好把优化前的第二while替代掉
        """
        heights.append(0)
        stack = [-1]
        for i in range(len(heights)):
            while heights[i] < heights[stack[-1]]:
                max_area = max(max_area, heights[stack.pop()] * (i - stack[-1] - 1))
            stack.append(i)
        return max_area

# leetcode submit region end(Prohibit modification and deletion)
