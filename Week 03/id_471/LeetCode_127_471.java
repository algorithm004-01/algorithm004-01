class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int level = 1;
        
        for (String word : wordList) {
            wordSet.add(word);
        }
        
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> tempSet = new HashSet<>();
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char oldChar = wordArray[i];
                    for (int j = 0; j < 26; j++) {
                        wordArray[i] = (char)('a' + j);
                        String wordString = String.valueOf(wordArray);
                        if (endSet.contains(wordString)) {
                                return level + 1;
                        }
                        if (!visited.contains(wordString) && wordList.contains(wordString)) {
                            //System.out.println(wordString);
                            
                            visited.add(wordString);
                            tempSet.add(wordString);
                        }
                    }
                    wordArray[i] = oldChar;
                }
            }
            beginSet = tempSet;
            level++;
        }
          
        return 0;
    }
}