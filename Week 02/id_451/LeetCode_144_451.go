/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type Stack struct {
	list *list.List
}

func NewStack() *Stack {
	list := list.New()
	return &Stack{list}
}

func (stack *Stack) Push(value interface{}) {
	stack.list.PushBack(value)
}

func (stack *Stack) Pop() interface{} {
	e := stack.list.Back()
	if e != nil {
		stack.list.Remove(e)
		return e.Value
	}
	return nil
}
func (stack *Stack) Len() int {
	return stack.list.Len()
}
func preorderTraversal(root *TreeNode) (res []int) {
	s := NewStack()
	t := root
	for t != nil || s.Len() > 0 {
		if t == nil {
			t = s.Pop().(*TreeNode)
			t = t.Right
			continue
		}
		res = append(res, t.Val)
		s.Push(t)
		t = t.Left
	}
	return
}
