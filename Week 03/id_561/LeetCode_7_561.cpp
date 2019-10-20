// 这道题用了两种解法, 算法复杂度一致, 但是第二种参考了题解中的代码, 更加简洁高效, 执行时间分别是 4ms 和 0ms.

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int count = 0;
        for (int i = 0; i < digits.size(); i++) {
            if (digits[i] != 9) break;
            count++;
        }

        if (count == digits.size()) {
            vector<int> result = vector<int> (count + 1, 0);
            result[0] = 1;
            return result;
        }

        digits[digits.size() - 1] += 1;

        for (int i = digits.size() - 1; i > 0; i--) {
            int cur_digit = digits[i];
            if (cur_digit > 9) {
                digits[i - 1] += digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
        }

        return digits;
    }
};

class SolutionV2 {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i = digits.size() - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }

        vector<int> result = vector<int>(digits.size() + 1, 0);
        result[0] = 1;

        return result;
    }
};
