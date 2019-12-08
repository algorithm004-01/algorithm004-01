import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode-cn.com/problems/word-ladder-ii
// 单词接龙II

public class LeetCode_126_716 {
    // 1. bfs
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) return res;
        
        bfs(beginWord, endWord, wordList, res);
        return res;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> res) {
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<String>(){{
            add(beginWord);
        }});

        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        boolean isFound = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> curr = queue.poll();
                String last = curr.get(curr.size() - 1);
                // find neighbors
                List<String> neighbors = getNeighbors(last, wordSet);

                // iter neighbors
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                            curr.add(neighbor);
                            res.add(new ArrayList<>(curr));
                            curr.remove(curr.size() - 1);
                        }
                        curr.add(neighbor);
                        queue.offer(new ArrayList<>(curr));
                        curr.remove(curr.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
                
            }
            visited.addAll(subVisited);
            if (isFound) break;
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbor = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < wordChars.length; i++) {
                if (wordChars[i] == ch) continue;
                char old = wordChars[i];
                wordChars[i] = ch;
                if (wordSet.contains(String.valueOf(wordChars) {
                    neighbor.add(String.valueOf(wordChars));
                }
                wordChars[i] = old;
            }
        }
        return neighbor;
    }
}