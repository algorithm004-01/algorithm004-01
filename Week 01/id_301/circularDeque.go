package main

import "fmt"

type MyCircularDeque struct {
	size   int
	length int
	data   []int
}

/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	var circularDeque MyCircularDeque
	circularDeque = *new(MyCircularDeque)
	circularDeque.size = k
	circularDeque.length = 0
	return circularDeque
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}
	this.data = append([]int{value}, this.data...)
	this.length++
	return true
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}
	this.data = append(this.data, value)
	this.length++
	return true
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}
	if this.length == 1 {
		this.data = []int{}
	} else {
		this.data = this.data[1:]
	}
	this.length--
	return true
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}
	if this.length == 1 {
		this.data = []int{}
	} else {
		this.data = this.data[:this.length-1]
	}
	this.length--
	return true
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.IsEmpty() {
		return -1
	}
	val := this.data[0]
	return val
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.IsEmpty() {
		return -1
	}
	val := this.data[this.length-1]
	return val
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	if this.length == 0 {
		return true
	}
	return false
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	if this.size == this.length {
		return true
	} else {
		return false
	}
}

func main() {
	c := Constructor(3)
	fmt.Println(c.size)
	fmt.Println(c.InsertFront(3))
	fmt.Println(c.length)
	fmt.Println(c.InsertLast(1))
	fmt.Println(c.length)
	fmt.Println(c.InsertLast(10))
	fmt.Println(c.length)
	fmt.Println(c.InsertLast(11))
	fmt.Println(c.length)
	fmt.Println(c.InsertLast(11))
	fmt.Println(c.length)
	//fmt.Println(c.DeleteFront())
	fmt.Println(c.length)
	fmt.Println(c.IsFull())
}
