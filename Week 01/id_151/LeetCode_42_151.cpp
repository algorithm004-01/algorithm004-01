class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> s;
        s.push(0);
        int ret = 0;
        for (int i = 1; i < height.size(); ++i) {
            while (! s.empty() && height[i] >= height[s.top()]) {
                int top = s.top();
                s.pop();
                
                if (s.empty())
                    break;
                
                int distance = i - s.top() - 1;
                int min_height = min(height[i], height[s.top()]) - height[top];
                ret += distance * min_height;
            }
            s.push(i);
        }
        return ret;
    } 
};
