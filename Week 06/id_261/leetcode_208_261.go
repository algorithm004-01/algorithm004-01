// leetcode : https://leetcode-cn.com/problems/implement-trie-prefix-tree

type Trie struct {
    node map[rune]*Trie
    isEnd bool
}


/** Initialize your data structure here. */
func Constructor() Trie {
    return Trie{node: map[rune]*Trie{}}
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
    t := this
    for i, c := range word {
        if _, ok := t.node[c]; !ok {
            trie := Constructor()
            t.node[c] = &trie
        } 
        t = t.node[c]
        if i == len(word) - 1 {
            t.isEnd = true
        }
    }
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
    t := this
    for i, c := range word {
        if _, ok := t.node[c]; !ok {
            return false
        } else {
            if i == len(word) - 1 {
               return t.node[c].isEnd
            }
        }
        t = t.node[c]
    }
    return false
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
    t := this
    for _, c := range prefix {
        if _, ok := t.node[c]; !ok {
            return false
        }
        t = t.node[c]
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