// leetcode : https://leetcode-cn.com/problems/decode-ways/

func numDecodings(s string) int {
    n := len(s)
    a := make([][]int, n)
    a[0] = []int{1, 0}
    if s[0] >= '1' && s[0] <= '2' {
        a[0][1] = 1
    }
    if s[0] == '0' {
        return 0
    }
    for i := 1; i < n; i++ {
        if s[i] == '0' {
            if s[i-1] == '0' || s[i-1] > '2' {
                return 0
            }
            if a[i-1][1] >= 0 {
                a[i] = []int{a[i-1][1], 0}
            } else {
                a[i] = []int{a[i-1][0], 0}
            }
            continue
        }
        num := 0
        if s[i] >= '1' && s[i] <= '2' {
            num = a[i-1][0]
        }
        if s[i-1] == '1' || (s[i-1] == '2' && s[i] <= '6') {
            a[i] = []int{a[i-1][0] + a[i-1][1], num}
        } else {
            a[i] = []int{a[i-1][0], num}
        }
    }
    return a[n-1][0]
}