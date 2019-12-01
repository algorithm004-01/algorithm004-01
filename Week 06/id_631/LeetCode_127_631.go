func ladderLength(beginWord string, endWord string, wordList []string) int {
	flag := false
	for _, word := range wordList {
		if word == endWord {
			flag = true
			break
		}
	}
	if !flag {
		return 0
	}

	// 2. 预处理+bfs, 40ms
	visitedMap := make(map[string]bool)
	preMap := make(map[string][]string)          // 预处理结果map
	queue := []string{beginWord}
	count := 0
	wordLen := len(beginWord)

	for _, word := range wordList {              // 预处理
		for i := 0; i < wordLen; i++ {
			key := word[:i] + "*" + word[i+1:]
			preMap[key] = append(preMap[key], word)
		}
	}

	for len(queue) > 0 {
		count++
		newQueue := make([]string, 0)
		for _, item := range queue {
			for i := 0; i < wordLen; i++ {
				key := item[:i] + "*" + item[i+1:]
				for _, word := range preMap[key] {
					if word == endWord {
						return count + 1
					}
					if !visitedMap[word] {
						visitedMap[word] = true
						newQueue = append(newQueue, word)
					}
				}
			}
		}
		queue = newQueue
	}
	return 0
}