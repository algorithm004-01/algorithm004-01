
class Solution {
public:
	/**
	 * 0            k           2k          3k
	 * |-----------|-----------|-----------|---
	 * +--reverse--+           +--reverse--+
	 */
	string reverseStr(string s, int k) {
		for (int left = 0; left < s.size(); left += 2 * k) {
			for (int i = left, j = min(left + k - 1, (int)s.size() - 1); i < j; i++, j--) {
				swap(s[i], s[j]);
			}
		}
		return s;
	}
};
