package algorithm00401

type Trie struct {
	val   byte
	sons  [26]*Trie
	isEnd bool
}

func Constructor() Trie {
	return Trie{}
}

func (this *Trie) Insert(word string) {
	for i := 0; i < len(word); i++ {
		idx := word[i] - 'a'
		if this.sons[idx] == nil {
			this.sons[idx] = &Trie{val: word[i]}
		}
		this = this.sons[idx]
	}
	this.isEnd = true
}

func (this *Trie) Search(word string) bool {
	for i := 0; i < len(word); i++ {
		idx := word[i] - 'a'
		if this.sons[idx] == nil {
			return false
		}
		this = this.sons[idx]
	}
	return this.isEnd
}

func (this *Trie) StartsWith(prefix string) bool {
	for i := 0; i < len(prefix); i++ {
		idx := prefix[i] - 'a'
		if this.sons[idx] == nil {
			return false
		}
		this = this.sons[idx]
	}
	return true
}
