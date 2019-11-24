class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //all words are of same length
        int L = beginWord.length();

        //Dictionary to hold combination of words that can be formed
        HashMap<String,ArrayList<String>> allComboDict = new HashMap<String,ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++){
                        //key is generic word
                        //value is a list of words
                        String newWord = word.substring(0,i) + "*" + word.substring(i + 1,L);
                        ArrayList<String> transformations = allComboDict.getOrDefault(newWord, newArrayList<String>());
                        //为什么这里要用List呀
                        //一个newWord可能有多个word
                        transformations.add(word);
                        allComboDict.put(newWord,transformations);
                    }
                }
        );

        //Queue for BFS
        Queue<Pair<String,Integer>> Q = new LinkedList<Pair<String,Integer>>();
        Q.add(new Pair(beginWord,1));

        //Visted to make sure we don't repeat processing same word
        HashMap<String,Boolean> visited = new HashMap<String,Boolean>();
        visited.put(beginWord, true);

        while( !Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for(int i = 0; i < L; i++) {

                //Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                //next states are all the words which share the same intermediate state
                for (String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    //if at any point if we find what we are looking for
                    //i.e the end word - we can return with the answer
                    if (adjacentWord.equals(endWord)){
                        return level + 1;
                    }

                    //otherwise,add it to the BFS Queue,Also male it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0 ;
    }

    //双端BFS
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while( !beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word: beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++){
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if(endSet.contains(target)){
                            return len + 1;
                        }

                        if( !visited.contains(target) && wordlist.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }

                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++''
        }
        return 0;
    }
