package main

import "fmt"

func mySqrt(x int) int {
	if x == 0 || x == 1 {
		return x
	}
	var mid int
	left, right := 0, x
	for left < right {
		mid = left + (right-left+1)/2
		if mid*mid > x {
			right = mid - 1
		} else {
			left = mid
		}
	}
	return left
}

func main() {
	fmt.Println(mySqrt(9))
}
