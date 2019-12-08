type Trie struct {
	root *Node
}

type Node struct {
	value        int32
	children       []*Node
	isComplete bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		root: &Node{
			children: make([]*Node, 0),
		},
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	node := this.root
	wLen := len(word)
	for i, w := range word {
		var childrenRoot *Node
		nodes := node.children
		for _, n := range nodes {
			if n.value == w {
				childrenRoot = n
				break
			}
		}
		if childrenRoot == nil {
			childrenRoot = &Node{value: w, children: make([]*Node, 0)}
			node.children = append(node.children, childrenRoot)
		}
		if i == wLen-1 {
			childrenRoot.isComplete = true
		}
		node = childrenRoot
	}
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node := this.root
	wLen := len(word)
	for i, w := range word {
		var childrenRoot *Node
		nodes := node.children
		for i, n := range nodes {
			if n.value == w {
				childrenRoot = nodes[i]
				break
			}
		}
		if childrenRoot == nil {
			return false
		}
		if i == wLen-1 && childrenRoot.isComplete {
			return true
		}
		node = childrenRoot
	}
	return false
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	node := this.root
	wLen := len(prefix)
	for i, w := range prefix {
		var childrenRoot *Node
		nodes := node.children
		for i, n := range nodes {
			if n.value == w {
				childrenRoot = nodes[i]
				break
			}
		}
		if childrenRoot == nil {
			return false
		}
		if i == wLen - 1 {
			return true
		}
		node = childrenRoot
	}
	return false
}