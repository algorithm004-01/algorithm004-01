import javafx.util.Pair;

import java.util.*;

class Solution {
    private int L = 0;
    private Map<String, ArrayList<String>> allComboDict;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        L = beginWord.length();
        allComboDict = new HashMap<String, ArrayList<String>>();
        for (String str : wordList) {
            for (int i = 0; i < L; i++) {
                String newString = str.substring(0, i) + "*" + str.substring(i + 1, L);
                ArrayList<String> transformations = allComboDict.getOrDefault(newString, new ArrayList<String>());
                transformations.add(str);
                allComboDict.put(newString, transformations);
            }
        }
        Queue<Pair<String, Integer>> q_begin = new LinkedList<Pair<String, Integer>>();
        Queue<Pair<String, Integer>> q_end = new LinkedList<Pair<String, Integer>>();
        q_begin.add(new Pair<String, Integer>(beginWord, 1));
        q_end.add(new Pair<String, Integer>(endWord, 1));
        Map<String, Integer> vistedBegin = new HashMap<String, Integer>();
        vistedBegin.put(beginWord, 1);
        Map<String, Integer> vistedEnd = new HashMap<String, Integer>();
        vistedEnd.put(endWord, 1);
        while(!q_begin.isEmpty() && !q_end.isEmpty()){
            int ans = vistedCount(q_begin, vistedBegin, vistedEnd);
            if(ans > -1){
                return ans;
            }
            ans = vistedCount(q_end, vistedEnd, vistedBegin);
            if(ans > -1){
                return ans;
            }
        }
        return 0;

    }
    private int vistedCount(Queue<Pair<String, Integer>> queue, Map<String, Integer> visted, Map<String, Integer> otherVisted){
        Pair<String, Integer> node = queue.remove();
        String str = node.getKey();
        int level = node.getValue();
        for (int i = 0; i < L; i++) {
            String newString = str.substring(0, i) + "*" + str.substring(i + 1, L);
            for(String adjacentWord : allComboDict.getOrDefault(newString, new ArrayList<>())){
                if(otherVisted.containsKey(adjacentWord)){
                    return level + otherVisted.get(adjacentWord);
                }
                if(!visted.containsKey(adjacentWord)){
                    visted.put(adjacentWord, level + 1);
                    queue.add(new Pair<String, Integer>(adjacentWord, level +1));
                }
            }
        }
        return -1;
    }
}