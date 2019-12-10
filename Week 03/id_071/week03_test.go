package week03

import "testing"

func TestMySqrt(t *testing.T) {
	s := mySqrt(25)
	t.Log(s)
}

func TestIsPerfectSquare(t *testing.T) {
	s := isPerfectSquare(15)
	t.Log(s)
}

func TestSearch(t *testing.T) {
	arr := []int{4, 5, 6, 7, 0, 1, 2}
	s := search(arr, 6)
	t.Log(s)
}

func TestFindMin(t *testing.T) {
	arr := []int{4, 5, 6, 7, 8, 2, 3}
	s := findMin(arr)
	t.Log(s)
}

func TestLemonadeChange(t *testing.T) {
	arr := []int{5, 10, 5, 10, 20}
	s := lemonadeChange(arr)
	t.Log(s)
}

func TestMaxProfit(t *testing.T) {
	arr := []int{7, 1, 5, 3, 6, 4}
	s := maxProfit1(arr)
	t.Log(s)
}
