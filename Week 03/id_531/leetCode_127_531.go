package id_531

//func ladderLength(beginWord string, endWord string, wordList []string) int {
//	// 所有的单词都是一个长度
//	lth := len(beginWord)
//	//通用状态树
//	grapMap := createStateGraph(wordList)
//
//	return 0
//}
//
//func createStateGraph(words []string) map[string][]string {
//	result := make(map[string][]string)
//	for _, word := range words {
//		wordRune := []rune(word)
//		for i := 0; i <= len(wordRune); i++ {
//
//		}
//	}
//	return result
//}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	dict := make(map[string]bool) // 把word存入字典
	for _, word := range wordList {
		dict[word] = true // 可以利用字典快速添加、删除和查找单词
	}
	if _, ok := dict[endWord]; !ok {
		return 0
	}

	//题解，所有的单词都是一个长度
	lgt := len(beginWord)
	var steps int

	var queue []string
	queue = append(queue, beginWord)

	for len(queue) > 0 {
		steps++
		size := len(queue)
		for i := size; i > 0; i-- { // 当前层级节点
			// 原始单词,queue.pop()
			word := queue[0]
			queue = queue[1:]
			chs := []rune(word)
			for i := 0; i < lgt; i++ { // 对单词的每一位进行修改
				ch := chs[i]                  // 对当前单词的一位
				for c := 'a'; c <= 'z'; c++ { // 尝试从a-z
					if c == ch { // 跳过本身比如hot修改为hot
						continue
					}
					chs[i] = c
					newWord := string(chs)
					if newWord == endWord { // 找到结果
						return steps + 1
					}
					if _, ok := dict[newWord]; !ok { // 不在dict中，跳过
						continue
					}
					delete(dict, newWord)          // 从字典中删除该单词，因为已经访问过，若重复访问路径一定不是最短的
					queue = append(queue, newWord) // 将新的单词添加到队列
				}
				chs[i] = ch // 单词的第i位复位，再进行下面的操作
			}
		}
	}
	return 0
}
