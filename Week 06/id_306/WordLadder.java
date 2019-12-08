package sf.week6;

import java.util.*;

/**
 * Created by LynnSun on 2019/11/24.
 * 力扣题目地址：https://leetcode-cn.com/problems/word-ladder
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0; // O(n)，可先放入HashSet--O(1)
        if (beginWord.equals(endWord)) return 2;

        // 预处理 双端广度优先 避免重复访问 递归 总是从少找向多
        // 预处理
        Map<String, Set<String>> patternMap = this._getPatternMap(wordList);

        // 双端广度优先
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();

        // 递归
        return this._search(1, beginSet, endSet, visited, patternMap);
    }

    // BFS starts here
    private int _search(int level, Set<String> beginSet, Set<String> endSet,
                        Set<String> visited, Map<String, Set<String>> patternMap) {
        // terminator
        if (beginSet.size() == 0 || endSet.size() == 0) return 0; // 双端都找不到了

        // process
        visited.addAll(beginSet);
        level++;
        Set<String> nextLevelSet = new HashSet<>();

        // 遍历beginSet
        for (String beginWord : beginSet) {
            Set<String> neighbors = this._getNeighbors(beginWord, patternMap);
            // 遍历所有相邻词
            for (String neighbor : neighbors) {
                if (visited.contains(neighbor)) continue; // 避免重复访问
                if (endSet.contains(neighbor)) return level; // 已找到
                // 未找到，把相邻词记入下一层
                nextLevelSet.add(neighbor);
            }
            // 不能再此处 nextLevelSet.addAll(neighbors); 因为不能将 visited.contains(neighbor) 的节点放入 nextLevelSet
        }

        // drill down
        // 总是从少找向多
        if (nextLevelSet.size() <= endSet.size()) {
            beginSet = nextLevelSet;
        } else {
            beginSet = endSet;
            endSet = nextLevelSet;
        }

        return this._search(level, beginSet, endSet, visited, patternMap);

        // reverse state
    }

    // 返回给定单词表的所有匹映射，key为带*的匹配键，value为该匹配键可对应的单词集合
    private Map<String, Set<String>> _getPatternMap(List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : wordList) {
            Set<String> keys = this._getPatterns(word);
            for (String key : keys) {
                if (!map.containsKey(key)) map.put(key, new HashSet<>());
                map.get(key).add(word);
            }
        }
        return map;
    }

    // 返回给定单词的所有可能的带*匹配键
    private Set<String> _getPatterns(String word) {
        Set<String> res = new HashSet<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            arr[i] = '*';
            res.add(String.valueOf(arr));
            arr[i] = temp;
        }
        return res;
    }

    // 返回给定单词、在给定匹配映射中的所有可能的相邻单词
    private Set<String> _getNeighbors(String word, Map<String, Set<String>> patternMap) {
        Set<String> res = new HashSet<>();
        Set<String> patterns = this._getPatterns(word);
        for (String pattern : patterns) {
            if (!patternMap.containsKey(pattern)) continue;
            res.addAll(patternMap.get(pattern));
        }
        return res;
    }
}
