package week08

import (
	_ "fmt"
	"math"
	"strconv"
)

// 2.2 https://leetcode-cn.com/problems/string-to-integer-atoi/
func myAtoi(str string) int {
	result, sign, start := 0, 1, false
	for _, v := range str {
		if v == ' ' && !start{
			continue
		}else if v == '+' && !start{
			sign = 1
			start = true
			continue
		}else if v == '-' && !start{
			sign = -1
			start = true
			continue
		}
		if '0' <= v && v <= '9' {
			start = true
			value, _ := strconv.Atoi(string(v))
			result = result*10 + value
			if result*sign > math.MaxInt32 {
				return math.MaxInt32
			}else if result*sign < -math.MaxInt32 - 1 {
				return -math.MaxInt32 - 1
			}
		}else{
			break
		}
	}
	return result*sign
}