package main

import "fmt"

func letterCombinations(digits string, path string, res *[]string) {
	if len(digits) == len(path) {
		*res = append(*res, path)
		return
	}
	numMap := map[string][]string{
		"2": {"a", "b", "c"},
		"3": {"d", "e", "f"},
		"4": {"g", "h", "i"},
		"5": {"j", "k", "l"},
		"6": {"m", "n", "o"},
		"7": {"p", "q", "r", "s"},
		"8": {"t", "u", "v"},
		"9": {"w", "x", "y", "z"},
	}
	for _, v := range numMap[string(digits[len(path)])] {
		path = path + string(v)
		letterCombinations(digits, path, res)
		fmt.Println(1)
		path = path[:len(path)-1]
	}
}
