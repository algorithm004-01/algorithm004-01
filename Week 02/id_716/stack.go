package id_716

// Stack 的实现
// golang 中没有内置的 Stack 结构，需要自己扩展实现
type node struct {
	value interface{}
	prev  *node
}

type LinkedStack struct {
	top *node
	size int
}

func NewLinkedStack() *LinkedStack {
	return &LinkedStack{nil, 0}
}

func (s *LinkedStack) isEmpty() bool {
	return s.size <= 0
}

func (s *LinkedStack) Push(value interface{}) bool {
	n := &node{value: value, prev: s.top}
	s.top = n
	s.size++
	return true
}

func (s *LinkedStack) Pop() interface{} {
	if s.isEmpty() { return nil }

	item := s.top
	s.top = s.top.prev
	s.size--
	return item.value
}