func hammingWeight(num uint32) int {
    count := 0
    for i := 0; i < 32; i++ {
        if (num >> i) & 1 == 1 {
            count++
        }
    }
    return count
}