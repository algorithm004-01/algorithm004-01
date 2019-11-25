//1.3 https://leetcode-cn.com/problems/decode-ways/

func numDecodings(s string) int {
    if string(s[0]) == "0" {
        return 0
    }

    table := make([]int, len(s))
    table[0] = 1

    for i := 1; i < len(s); i++ {
        if string(s[i]) == "0" && string(s[i-1]) == "0" {
            return 0
        }
        
        if string(s[i]) != "0" {
            table[i] = table[i-1]
        }
        
        if string(s[i-1]) == "0" {
            continue
        }
        
        if n, _ := strconv.Atoi(s[i-1 : i+1]); n > 0 && n <= 26 {
            if i == 1 {
                table[i]++
            } else {
                table[i] += table[i-2]
            }
        }
    }

    return table[len(table)-1]
}