package main

import "fmt"

func isAnagram(s string, t string) bool {
	lenS := len(s)
	lenT := len(t)
	if lenS != lenT {
		return false
	}
	if s == "" && t == "" {
		return true
	}
	sliceS := []byte(s)
	sliceT := []byte(t)
	var charMap map[byte]int
	charMap = make(map[byte]int)
	for i := 0; i < lenS; i++ {
		charMap[sliceS[i]]++
		charMap[sliceT[i]]--
	}

	for _, v := range charMap {
		if v != 0 {
			return false
		}
	}
	return true
}

func main() {
	root := new(TreeNode)
	root.Val = 1
	root.Left = new(TreeNode)
	root.Left.Val = 2
	root.Right = new(TreeNode)
	root.Right.Val = 3

	fmt.Println(inorderTraversal(root))
}
