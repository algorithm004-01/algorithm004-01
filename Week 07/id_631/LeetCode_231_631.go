func isPowerOfTwo(n int) bool {
    if n < 0 {
        return false;
    } 
    count := 0
    for i := 0; i < 32; i++ {
        if (n >> i) & 1 == 1 {
            count++
        }
    }
    return count == 1
}