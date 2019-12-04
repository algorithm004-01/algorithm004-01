class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t t = 0;
        uint32_t mask = 1;
        for(int i = 0; i < 32; i++){
            if(n & mask) {
                t = (t | (1 << (31 - i)));
            }
            mask <<= 1;
        }
        return t;
    }
};