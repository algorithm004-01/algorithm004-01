class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int carry = 1;
        int count = 0;
        for (int i = digits.size() - 1; i >= 0; --i, ++count) {
            int& n = digits[i];
            n += carry;
            if (n % 10 == 0) {
                n = 0;
                continue;
            } 
            break;
        }
        if (count == digits.size()) {
            digits.push_back(0);
            digits[0] = 1;
        }
        return digits;
    }
};
