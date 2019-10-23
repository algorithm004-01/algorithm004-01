package week01/id_071

import (
	_ "fmt"
	"testing"
)

func TestMoveZero(t *testing.T) {
	var nums = []int{0, 8, 0, 0, 0, 4, 8, 3, 7}

	// moveZero(nums)
	// t.Log(nums)
	moveZeroes(nums)
	t.Log(nums)
}

func TestMaxArea(t *testing.T) {
	var nums = []int{1, 8, 6, 2, 5, 4, 8, 3, 7}

	max := maxArea(nums)
	t.Log(max)
}

func TestThreeSum(t *testing.T) {
	var nums = []int{-1, 0, 1, 2, -1, -4, 4, 0, -2}

	n := threeSumes(nums)
	t.Log(n)
}

func TestTwoSum(t *testing.T) {
	// target := 6
	// nums := []int{3,2,4}

	target := 9
	nums := []int{2, 7, 11, 15}

	s := twoSum(nums, target)
	t.Log(s)
}

func TestRotate(t *testing.T) {
	arr := []int{1, 2, 4, 5, 7, 8, 0}
	rotate(arr, 2)
	t.Log(arr)
}

func TestInsertFront(t *testing.T) {

	circularDeque := Constructor(3)

	circularDeque.InsertLast(1)
	circularDeque.InsertLast(2)
	t.Log(circularDeque.InsertLast(3))
	t.Log(circularDeque)
	circularDeque.InsertLast(4)
	circularDeque.InsertLast(5)
	t.Log(circularDeque)
}

func TestTrap(t *testing.T) {
	arr := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}

	t.Log(trap(arr))
}
