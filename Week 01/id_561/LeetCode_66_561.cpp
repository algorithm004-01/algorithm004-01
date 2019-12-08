// 加一
//
// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
// 输出: [1,2,4]
// 解释: 输入数组表示数字 123。
// 示例 2:
//
// 输入: [4,3,2,1]
// 输出: [4,3,2,2]
// 解释: 输入数组表示数字 4321。
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/plus-one
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

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
