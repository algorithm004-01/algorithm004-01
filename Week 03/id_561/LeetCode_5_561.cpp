// 这道题我用了两种方法来做, 一种是排序 + 双指针, 另一种是用哈希表
// 算法的时间复杂度, 前者是 O(N*logN), 后者是 O(N),
// 但是实际提交后, 前者只用了 4ms, 后者是 8ms, 可能跟哈希表的创建耗时有关系

// 第一种方法:
// 因为想通过双指针来做, 需要先对数组做排序, 所以创建一个类来保存数组元素的 value 和 index
struct Number {
    int value;
    int index;

    Number(int value, int index) {
        this->value = value;
        this->index = index;
    }
};

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<Number> input;
        int i = 0;
        for (auto &a : nums) {
            input.push_back(Number(a, i++));
        }

        // 排序
        sort(input.begin(), input.end(), [](Number x, Number y) { return x.value < y.value; });

        int left = 0;
        int right = input.size() - 1;
        vector<int> result = {};

        while (left < right) {
            int sum = input[left].value + input[right].value;
            if (sum == target) {
                result.push_back(input[left].index);
                result.push_back(input[right].index);
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
};

// 第二种方法:
// 用哈希表来保存 table[target - nums[i]] -> i
class SolutionV2 {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mem;

        for (int i = 0; i < nums.size(); i++) {
            if (mem.find(target - nums[i]) != mem.end())
                return vector<int> ({mem[target - nums[i]], i});
            mem[nums[i]] = i;
        }

        return vector<int>({-1, -1});
    }
};
