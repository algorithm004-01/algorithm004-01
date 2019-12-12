class Solution {
public:
    int totalNQueens(int n) {
        int count = 0;
        solve(0, n, 0, 0, 0, count);
        
        return count;
    }
    
    void solve(int level, int n, uint32_t shu, uint32_t pie, uint32_t na, int& count) {
        if (level >= n) {
            ++count;
            return;
        }
        
        uint32_t bit = (~(shu | pie | na)) & ((1 << n) - 1);
        while (bit) {
            uint32_t p = bit & -bit;
            bit = bit & (bit - 1);
            solve(level + 1, n, shu | p, (pie | p) << 1, (na | p) >> 1, count);
        }
    }
};
