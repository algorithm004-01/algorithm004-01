# 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
#
# 
# push(x) -- 将元素 x 推入栈中。 
# pop() -- 删除栈顶的元素。 
# top() -- 获取栈顶元素。 
# getMin() -- 检索栈中的最小元素。 
# 
#
# 示例: 
#
# MinStack minStack = new MinStack();
# minStack.push(-2);
# minStack.push(0);
# minStack.push(-3);
# minStack.getMin();   --> 返回 -3.
# minStack.pop();
# minStack.top();      --> 返回 0.
# minStack.getMin();   --> 返回 -2.
# 
# Related Topics 栈 设计

"""
方法一：辅助栈和数据栈同步
方法二：辅助栈和数据栈不同步
2 二元组同步栈
"""


# leetcode submit region begin(Prohibit modification and deletion)
class MinStack(object):
    """
    # 辅助栈和数据栈同步
    # 思路简单不容易出错
    """

    def __init__(self):
        """
        initialize your data structure here.
        """
        # 数据栈
        self.data = []
        # 辅助栈
        self.helper = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.data.append(x)
        # 这里 x < self.helper[-1] 或者 x <= self.helper[-1] 都可以
        if len(self.helper) == 0 or x <= self.helper[-1]:
            self.helper.append(x)
        else:
            self.helper.append(self.helper[-1])

    def pop(self):
        """
        :rtype: None
        """
        if self.data:
            del self.helper[-1]
            del self.data[-1]

    def top(self):
        """
        :rtype: int
        """
        if self.data:
            return self.data[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.helper:
            return self.helper[-1]


class MinStackNoSync(object):
    """
    # 辅助栈和数据栈不同步
    # 关键 1：辅助栈的元素空的时候，必须放入新进来的数
    # 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
    # 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了
    """

    def __init__(self):
        """
        initialize your data structure here.
        """
        # 数据栈
        self.data = []
        # 辅助栈
        self.helper = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.data.append(x)
        # 关键1 和 关键2
        if len(self.helper) == 0 or x <= self.helper[-1]:
            self.helper.append(x)

    def pop(self):
        """
        :rtype: None
        """
        if self.data:
            if self.data[-1] == self.helper[-1]:
                del self.helper[-1]
                del self.data[-1]

    def top(self):
        """
        :rtype: int
        """
        if self.data:
            return self.data[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.helper:
            return self.helper[-1]


class MinStackTuple(object):
    def __init__(self):
        self.stack = []

    def push(self, x):
        if self.stack:
            self.stack.append((x, min(x, self.stack[-1][1])))
        else:
            self.stack.append((x, x))

    def pop(self):
        if self.stack:
            del self.stack[-1]

    def top(self):
        if self.stack:
            return self.stack[-1][0]

    def getMin(self):
        if self.stack:
            return self.stack[-1][1]


# 方法3 升级
class MinStack4(object):
    def __init__(self):
        self.data = [(None, float('inf'))]

    def push(self, x):
        self.data.append((x, min(x, self.data[-1][1])))

    def pop(self):
        if len(self.data) > 1:
            self.data.pop()
            # del self.data[-1]

    def top(self):
        return self.data[-1][0]

    def getMin(self):
        return self.data[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# leetcode submit region end(Prohibit modification and deletion)
