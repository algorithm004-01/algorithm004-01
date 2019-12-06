class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        vector<int> ret(digits);
		if (digits[0] == 0) {
			ret[0] = 1;
			return ret;
		}

		int index = digits.size() - 1;
		int mod = 0;
        
		while (index >= 0 && mod == 0) {
			ret[index] += 1;
			mod = ret[index--] % 10;
		}
		
		if (mod == 0) {
			ret.insert(ret.begin(), 1);
		}
		return ret;
    }
};
