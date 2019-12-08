//once 20191103 14:43
// BFS 
// 50.59%, 100%
func ladderLength3(beginWord string, endWord string, wordList []string) int {
    length := len(wordList)
    
    queue := append([]string{}, beginWord)
    steps := 0

    for len(queue) > 0 {
        steps++

        for i := len(queue); i > 0; i-- {
            s := queue[0] // pop front
            queue = queue[1:]
            
            if s == endWord {
                return steps
            }
            
            if steps >= length  && len(wordList) == 0 {
                return 0
            }
            
            for i := len(wordList) - 1; i >= 0; i-- {
                if isMatch(wordList[i], s) {
                    queue = append(queue, wordList[i])
                    wordList = append(wordList[0:i], wordList[i+1:]...)
                }
            } 
        }
    }
    
    return 0
}

func isMatch(from, to string) bool {
    counter := 0
    for i := 0; i < len(to); i++ {
        if from[i] != to[i] {
            counter++
        }
    }
    return counter == 1
}