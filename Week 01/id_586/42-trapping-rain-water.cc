class Solution {
public:
/*
我们可以不用像方法 2 那样存储最大高度，而是用栈来跟踪可能储水的最长的条形块。使用栈就可以在一次遍历内完成计算。

我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到 \text{ans}ans 。

算法

使用栈来存储条形块的索引下标。
遍历数组：
当栈非空且 height[current]>height[st.top()]
意味着栈中元素可以被弹出。弹出栈顶元素 top。
计算当前元素和栈顶元素的距离，准备进行填充操作
distance=current−st.top()−1
找出界定高度
bounded_height=min(height[current],height[st.top()])−height[top]
往答案中累加积水量 ans+=distance×bounded_height
将当前索引下标入栈
将 current 移动到下个位置
*/
    int trap(vector<int>& height) {
        int ans = 0, current = 0;
        stack<int> st;
        while (current < height.size()) {
            while (!st.empty() && height[current] > height[st.top()]) {
                int top = st.top();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.top() - 1;
                int bounded_height = min(height[current], height[st.top()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }
};
