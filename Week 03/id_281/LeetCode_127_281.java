import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jdk.internal.util.xml.impl.Pair;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     
        int L = beginWord.length();

        HashMap<String, ArrayList<String>> allCommonDict = new HashMap<String, ArrayList<String>>();
        wordList.forEach(
            word ->  {
                for (int i = 0; i < L; i++) {
                    String newWord  = word.substring(0, i) + '*' + word.substring(i + 1, L);
                    ArrayList<String> transforms = allCommonDict.getOrDefault(newWord, new ArrayList<String>());
                    transforms.add(word);
                    allCommonDict.put(newWord, transforms);
                }
            }
        );

        // Queue For BFS 
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getkey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord  = word.substring(0, i) + '*' + word.substring(i + 1, L);

                for (String adjacentWord : allCommonDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
// @lc code=end

