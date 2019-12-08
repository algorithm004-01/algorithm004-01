package medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/1
 */
public class WordLadder {
    /**
     * BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        Set<String> visited = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        deque.addLast(beginWord);
        visited.add(beginWord);
        while (!deque.isEmpty()) {
            int size = deque.size();
            level++;
            while (size-- > 0) {
                String current = deque.removeFirst();
                if (current.equals(endWord)) return level;
                char[] curChar = current.toCharArray();
                for (int i = 0; i < curChar.length; i++) {
                    char old = curChar[i];
                    for (char c = 'a'; c < 'z'; c++) {
                        if (old != c) {
                            curChar[i] = c;
                            String tmp = new String(curChar);
                            if (!visited.contains(tmp) && wordSet.contains(tmp)) {
                                deque.addLast(tmp);
                                visited.add(tmp);
                            }
                        }
                    }
                    curChar[i] = old;
                }
            }
        }
        return 0;
    }
}
