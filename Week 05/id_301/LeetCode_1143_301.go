package main

import "fmt"

func longestCommonSubsequence(text1 string, text2 string) int {
	len1 := len(text1)
	len2 := len(text2)
	if len1 == 0 || len2 == 0 {
		return 0
	}
	dp := make([][]int, len1+1)
	for i := 0; i <= len1; i++ {
		dp[i] = make([]int,len2+1)
	}
	for i := 1; i <= len1; i++ {
		for j := 1; j <= len2; j++ {
			if text1[i-1] == text2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	fmt.Println(dp)
	return dp[len1][len2]
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func letterCombinations(digits string) []string {
	length := len(digits)
	var res []string
	alphaMap := map[string][]string{
		"2":[]string{"a","b","c"},
		"3":[]string{"d","e","f"},
		"4":[]string{"g","h","i"},
		"5":[]string{"j","k","l"},
		"6":[]string{"m","n","o"},
		"7":[]string{"p","q","r","s"},
		"8":[]string{"t","u","v"},
		"9":[]string{"w","x","y","z"},
	}
	s := ""
	for i:=0;i<length;i++{
		s :=
	}
	return res
}

func dg()  {
	
}

func main() {
	fmt.Println(longestCommonSubsequence("abcde","ace"))
}
