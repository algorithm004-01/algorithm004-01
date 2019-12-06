/**
 * WordLadder
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int count = 1;
        Set<String> visited = new HashSet<>();
        int strLength = beginWord.length();

        if (dic.contains(endWord)) {
            beginSet.add(beginWord);
            endSet.add(endWord);
        }       

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() > endSet.size()){
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for(int i = 0; i < chs.length; ++i) {
                    for(char j = 'a';  j <= 'z'; ++j) {
                        char old = chs[i];
                        chs[i] = j;
                        String target = String.valueOf(chs);

                        if(endSet.contains(target))
                            return count + 1;

                        if(!visited.contains(target) && dic.contains(target)){
                            visited.add(target);
                            temp.add(target);
                        }
                        chs[i] = old;
                    }
                }
                beginSet = temp;
            }
            count++;
        }
        return 0;
    }
}