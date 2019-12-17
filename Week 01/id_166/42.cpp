class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
		vector<int> left(n), right(n);
		for (int i = 1; i < n; i++) {
			left[i] = max(left[i - 1], height[i - 1]);
		}
		for (int i = n - 2; i >= 0; i--) {
			right[i] = max(right[i + 1], height[i + 1]);
		}
		int water = 0;
		for (int i = 0; i < n; i++) {
			int level = min(left[i], right[i]);
			water += max(0, level - height[i]);
		}
		return water;
    }
};
