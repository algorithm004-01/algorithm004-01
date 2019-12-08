// leetcode : https://leetcode-cn.com/problems/reverse-bits

func reverseBits(num uint32) uint32 {
    result := uint32(0)
    for i := 0; i < 32; i++ {
        result = (result<<1)|(num&1)
        num = num>>1
    }
    return result
}