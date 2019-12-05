class Solution {
    
    private int min;

    private Set<String> visited = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        mutation(temp, endWord, wordList);
        return this.min + 1;
    }

    public void mutation(List<String> beginWordList, String endWord, List<String> wordList) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < beginWordList.size(); i++) {
            if (beginWordList.get(i).equals(endWord)) {
                return;
            }
            for (int j = 0; j < wordList.size(); j++) {
                if(visited.contains(wordList.get(j))){
                    continue;
                }
                int steps = 0;
                for (int k = 0; k < wordList.get(j).length(); k++) {
                    if (beginWordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        steps++;
                    }

                    if (steps > 1) {
                        break;
                    }
                }

                if (steps == 1) {
                    temp.add(wordList.get(j));
                    visited.add(wordList.get(j));
                }
            }
        }

        this.min++;
        if(temp.size() == 0 || this.min > wordList.size()){
            this.min = -1;
            return;
        }
        mutation(temp, endWord, wordList);
    }
}
