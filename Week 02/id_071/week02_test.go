package week02

import "testing"

func TestIsAnagram(t *testing.T) {

	s := "strings1"
	l := "sringst1"
	b := isAnagram(s, l)
	t.Log(b)
}

func TestTwoSum(t *testing.T) {

	nums := []int{1, 2, 3, 4, 6, 7, -2, -6, 5}
	target := 12
	targ := twoSum(nums, target)
	t.Log(targ)
}

func TestMajorityElement(t *testing.T) {
	arr := []int{2, 2, 1, 1, 1, 2, 2}
	m := majorityElement(arr)
	t.Log(t)
}

func testSolveNQueens(t *testing.T){

	t.Log(solveNQueens(5))
}
