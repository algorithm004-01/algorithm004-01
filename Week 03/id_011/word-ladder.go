package algorithm00401

func ladderLength(beginWord string, endWord string, wordList []string) int {
	dict := make(map[string]bool)
	for _, word := range wordList {
		dict[word] = true
	}
	if !dict[endWord] {
		return 0
	}
	step := 0
	q1 := map[string]bool{beginWord: true}
	q2 := map[string]bool{endWord: true}
	for len(q1) > 0 && len(q2) > 0 {
		step++
		if len(q1) > len(q2) {
			q1, q2 = q2, q1
		}
		q := make(map[string]bool)
		for w, _ := range q1 {
			for i := 0; i < len(beginWord); i++ {
				chars := []rune(w)
				for j := 'a'; j <= 'z'; j++ {
					chars[i] = j
					newWord := string(chars)
					if q2[newWord] {
						return step + 1
					}
					if !dict[newWord] {
						continue
					}
					delete(dict, newWord)
					q[newWord] = true
				}
			}
		}
		q1, q = q, q1
	}
	return 0
}
