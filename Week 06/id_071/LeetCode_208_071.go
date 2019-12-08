package week06

//1.1 https://leetcode-cn.com/problems/implement-trie-prefix-tree/
type Trie struct {
	isEnd bool
	children map[rune]*Trie    
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		isEnd: false,
		children: make(map[rune]*Trie),
	}
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	parent := this
	for _, r := range word {
		if child, ok := parent.children[r]; ok {
			parent = child
		}else{
			newChild := &Trie{isEnd: false,children:make(map[rune]*Trie)}
			parent.children[r] = newChild
			parent = newChild
		}
	}
	parent.isEnd = true
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	parent := this
    for _, r := range word {
		if child, ok := parent.children[r]; ok {
			parent = child
			continue
		}
		return false
	}
	return parent.isEnd
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	parent := this
	for _, r  := range prefix {
		if child, ok := parent.children[r]; ok {
			parent = child
			continue
		}
		return false
	}
	return true
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */