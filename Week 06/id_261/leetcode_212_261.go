// leetcode : https://leetcode-cn.com/problems/word-search-ii

type Trie struct {
    node map[rune]*Trie
    word string
}

func (this *Trie) Insert(word string)  {
    t := this
    for _, c := range word {
        if _, ok := t.node[c]; !ok {
            t.node[c] = &Trie{node: map[rune]*Trie{}}
        } 
        t = t.node[c]
    }
    t.word = word
}



var result map[string]bool

func findWords(board [][]byte, words []string) []string {
    result = make(map[string]bool)
    trie := &Trie{node: map[rune]*Trie{}}
    for _, word := range words {
        trie.Insert(word)
    }
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[i]); j++ {
            dfs(board, i, j, "", trie)
            if len(result) >= len(words) {
				return words
			}
        }
    }
    r := make([]string, len(result))
    i := 0
    for k, _ := range result {
        r[i] = k
        i++
    }
    return r
}

func dfs(board [][]byte, x, y int, str string, trie *Trie) {
    if x < 0 || y < 0 || x >= len(board) || y >= len(board[0]) {
        return
    }
    c := rune(board[x][y])
    if v, ok := trie.node[c]; !ok {
        return
    } else {
        trie = v
        if trie.word != "" {
            result[trie.word] = true
        }
    }
    tmp := board[x][y]
    board[x][y] = '$'
    dfs(board, x + 1, y, str, trie)
    dfs(board, x, y + 1, str, trie)
    dfs(board, x - 1, y, str, trie)
    dfs(board, x, y - 1, str, trie)
    board[x][y] = tmp
}