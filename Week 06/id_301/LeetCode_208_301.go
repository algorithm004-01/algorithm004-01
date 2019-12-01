package id_301

type Node struct {
	isWord bool
	next   map[string]*Node
}

func NewNode() *Node {
	return &Node{next: make(map[string]*Node)}
}

type Trie struct {
	root *Node
}

func Constructor() Trie {
	return Trie{root: NewNode()}
}

func (t *Trie) Insert(word string) {
	add(t.root, word, 0)
}

func add(node *Node, word string, index int) {
	if index == len(word) {
		if !node.isWord {
			node.isWord = true
		}
		return
	}

	c := string([]rune(word)[index])
	if node.next[c] == nil {
		node.next[c] = NewNode()
	}
	add(node.next[c], word, index+1)
}

func (t *Trie) Search(word string) bool {
	return contains(t.root, word, 0)
}

func contains(node *Node, word string, index int) bool {
	if index == len(word) {
		return node.isWord
	}

	c := string([]rune(word)[index])
	if node.next[c] == nil {
		return false
	}
	return contains(node.next[c], word, index+1)
}

func (t *Trie) StartsWith(prefix string) bool {
	return isPrefix(t.root, prefix, 0)
}

func isPrefix(node *Node, prefix string, index int) bool {
	if index == len(prefix) {
		return true
	}

	c := string([]rune(prefix)[index])
	if node.next[c] == nil {
		return false
	}

	return isPrefix(node.next[c], prefix, index+1)
}
