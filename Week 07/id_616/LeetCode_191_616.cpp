class Solution {
public:
    int hammingWeight(uint32_t n) {
        int cnt = 0;
        while(n) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }
};