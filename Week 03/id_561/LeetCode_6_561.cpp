// 用了两种解法, 解法 1 和 2 原理一样, 都是双指针 (快慢指针), 只是 2 使用元素交换来简化代码, 两者执行时间一致

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int left_index = 0;
        int right_index = 0;

        for (; right_index < nums.size(); right_index++) {
            if (nums[right_index] == 0)
                continue;

            if (left_index != right_index)
                nums[left_index++] = nums[right_index];
            else
                left_index++;
        }

        for (int j = left_index; j < nums.size(); j++) {
            nums[j] = 0;
        }
    }
};

class SolutionV2 {
public:
    void moveZeroes(vector<int> &nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.size(); cur++) {
            if (nums[cur] != 0) {
                swap(nums[lastNonZeroFoundAt++], nums[cur]);
            }
        }
    }
};
