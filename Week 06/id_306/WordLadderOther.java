package sf.week6;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LynnSun on 2019/11/24.
 */
public class WordLadderOther {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 2;

        // 可能遇见的节点集
        Set<String> meets = new HashSet<>(wordList); // O(n)

        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        return this._search(1, beginSet, endSet, meets);
    }

    private int _search(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        // terminator
        if (beginSet.size() == 0 || endSet.size() == 0) return 0;

        // process
        meets.removeAll(beginSet);
        level++;
        Set<String> nextLevelSet = new HashSet<>();
        // iter every begin word
        for (String beginWord : beginSet) {
            char[] chars = beginWord.toCharArray();
            // iter for every char
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                // replace every letter
                for (char ch = 'a'; ch < 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (!meets.contains(newWord)) continue;
                    if (endSet.contains(newWord)) return level;
                    nextLevelSet.add(newWord);
                }
                // reverse
                chars[i] = temp;
            }
        }

        // drill down
        // always from less to more
        if (nextLevelSet.size() <= endSet.size()) {
            beginSet = nextLevelSet;
        } else {
            beginSet = endSet;
            endSet = nextLevelSet;
        }

        return this._search(level, beginSet, endSet, meets);
    }
}
