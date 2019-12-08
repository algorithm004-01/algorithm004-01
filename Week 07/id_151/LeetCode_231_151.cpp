class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        
        uint64_t ln = n;
        return (ln & (ln - 1)) == 0;
    }
};
