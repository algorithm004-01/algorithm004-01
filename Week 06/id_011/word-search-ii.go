package algorithm00401

func findWords(board [][]byte, words []string) []string {
	var results []string

	m := len(board)
	n := len(board[0])
	if m == 0 || n == 0 {
		return results
	}

	trie := buildTrie(words)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(board, i, j, trie, &results)
		}
	}

	return results
}

type Trie struct {
	next [26]*Trie
	word string
}

func buildTrie(words []string) *Trie {
	root := new(Trie)
	for _, word := range words {
		cur := root
		for _, c := range word {
			idx := c - 'a'
			if cur.next[idx] == nil {
				cur.next[idx] = new(Trie)
			}
			cur = cur.next[idx]
		}
		cur.word = word
	}
	return root
}

func dfs(board [][]byte, i, j int, trie *Trie, results *[]string) {
	// termination
	c := board[i][j]
	if c == '#' || trie.next[c-'a'] == nil {
		return
	}

	// process logic of current level
	trie = trie.next[c-'a']
	if trie.word != "" {
		*results = append(*results, trie.word)
		trie.word = ""
	}
	board[i][j] = '#'

	// drill down
	if i > 0 {
		dfs(board, i-1, j, trie, results)
	}

	if i < len(board)-1 {
		dfs(board, i+1, j, trie, results)
	}

	if j > 0 {
		dfs(board, i, j-1, trie, results)
	}

	if j < len(board[0])-1 {
		dfs(board, i, j+1, trie, results)
	}

	// restore
	board[i][j] = c
}
