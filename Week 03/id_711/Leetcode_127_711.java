package Week3;

import javafx.util.Pair;

import java.util.*;

public class Leetcode_127_711 {

    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Leetcode_127_711 ss = new Leetcode_127_711();

        String beginWord = "hit";
        String endWord = "cog";
        String[] wordLists = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();
        for (String str:wordLists) {
            wordList.add(str);
        }
        System.out.println(ss.ladderLength1(beginWord,endWord,wordList));

    }

    /**
     * 沙雕最慢算法
     * 执行用时 :1066 ms, 在所有 java 提交中击败了5.74%的用户
     * 内存消耗 :41.8 MB, 在所有 java 提交中击败了60.94%的用户
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        map.put(beginWord,1);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            Queue<String> help = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                String str = queue.remove();

                //  这一步很费时间
                for (String s : wordList) {
                    if (map.containsKey(s))
                        continue;
                    if (check(str, s)) {
                        help.add(s);
                        map.put(s,map.get(str) + 1);
                    }
                }
            }
            queue = help;
        }
        if (map.containsKey(endWord))
            return map.get(endWord);
        return 0;
    }

    private boolean check(String str, String s) {
        char[] ch = str.toCharArray();
        char[] ch2 = s.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] != ch2[i]) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return true;
    }

    /**
     * 题解双向BFS做法
     * 写的啥啊。。。。。。。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

    private int L;
    private HashMap<String, ArrayList<String>> allComboDict;

    Leetcode_127_711() {
        this.L = 0;
        this.allComboDict = new HashMap<>();
    }

    private int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        this.L = beginWord.length();
        wordList.forEach(
            word -> {
                for (int i = 0; i < L; i++) {
                    // Key is the generic word
                    // Value is a list of words which have the same intermediate generic word.
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                    ArrayList<String> transformations =
                            this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
                    transformations.add(word);
                    this.allComboDict.put(newWord, transformations);
                }
            });

        // Queues for birdirectional BFS
        // BFS starting from beginWord
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
        // BFS starting from endWord
        Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
        HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

            // One hop from begin word
            int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }

            // One hop from end word
            ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }

        return 0;
    }

    private int visitWordNode(
            Queue<Pair<String, Integer>> Q,
            HashMap<String, Integer> visited,
            HashMap<String, Integer> othersVisited) {

        Pair<String, Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < this.L; i++) {

            // Intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

            // Next states are all the words which share the same intermediate state.
            for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                // If at any point if we find what we are looking for
                // i.e. the end word - we can return with the answer.
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {

                    // Save the level as the value of the dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

}
