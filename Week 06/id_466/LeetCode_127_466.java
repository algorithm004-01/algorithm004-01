//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索
package com.aseara.leetcode.editor.cn.a127;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 127.单词接龙 <br />
 * Date: 2019/10/31 <br/>
 *
 * @author qiujingde
 */
class WordLadder {
    private Solution solution = new Solution();

    @Test
    void test1() {
        String begin = "hit";
        String end = "cog";
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
        assertEquals(5, solution.ladderLength(begin, end, dict));

        begin = "hit";
        end = "cog";
        dict = Arrays.asList("hot","dot","dog","lot","log");
        assertEquals(0, solution.ladderLength(begin, end, dict));

        begin = "hot";
        end = "dot";
        dict = Arrays.asList("hot", "dog", "dot");
        assertEquals(2, solution.ladderLength(begin, end, dict));
    }

}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return path10(beginWord, endWord, wordList);
    }

    private int path1(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> checkList = new LinkedList<>();
        for (String w : wordList) {
            if (!w.equals(endWord)) {
                checkList.add(w);
            }
        }

        if (checkList.size() == wordList.size()) {
            return 0;
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int step = 1;
        while (!queue.isEmpty() && !wordList.isEmpty()) {
            step ++;
            int batch = queue.size();
            for (int i = 0; i < batch; i++) {
                String crt = queue.poll();
                if (canGo(crt, endWord)) {
                    return step;
                }
                int checkSize = checkList.size();
                for (int j = 0; j < checkSize; j++) {
                    String next = checkList.poll();
                    if (canGo(crt, next)) {
                        queue.add(next);
                    } else {
                        checkList.add(next);
                    }
                }
            }
        }

        return 0;
    }

    private boolean canGo(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            diff += a.charAt(i) == b.charAt(i) ? 0 : 1;
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    private int path2(String beginWord, String endWord, List<String> wordList) {
        // abc -> *bc, a*c, ab*
        Map<String, List<String>> map1 = new HashMap<>(wordList.size());
        // *bc -> abc, bbc, cbc
        Map<String, List<String>> map2 = new HashMap<>(wordList.size() * 3);

        for(String word : wordList) {
            fillMap(map1, map2, word);
        }
        fillMap(map1, map2, beginWord);

        if (map1.get(endWord) == null) {
            return 0;
        }

        // endWord -> *bc, a*c, ab*
        Set<String> checkSet = new HashSet<>(map1.remove(endWord));

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int step = 1;
        while (!queue.isEmpty() && !map1.isEmpty()) {
            step++;
            int batch = queue.size();
            for (int i = 0; i < batch; i++) {
                String crt = queue.poll();
                List<String> paths = map1.remove(crt);
                if (paths == null) {
                    continue;
                }
                for (String path: paths) {
                    if (checkSet.contains(path)) {
                        return step;
                    }
                    for (String next : map2.get(path)) {
                        if (map1.containsKey(next)) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private void fillMap(Map<String, List<String>> map1, Map<String, List<String>> map2, String word) {
        for (int i = 0; i < word.length(); i++) {
            String pathWord = word.substring(0, i) + '*' + word.substring(i + 1);
            map1.computeIfAbsent(word, k -> new LinkedList<>()).add(pathWord);
            map2.computeIfAbsent(pathWord, k -> new LinkedList<>()).add(word);
        }
    }

    // 双向BFS
    private int path3(String beginWord, String endWord, List<String> wordList) {
        // abc -> *bc, a*c, ab*
        Map<String, Set<String>> map1 = new HashMap<>(wordList.size());
        // *bc -> abc, bbc, cbc
        Map<String, Set<String>> map2 = new HashMap<>(wordList.size() * 3);

        for(String word : wordList) {
            fillSetMap(map1, map2, word);
        }
        fillSetMap(map1, map2, beginWord);

        if (!map1.containsKey(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        for (String path : map1.get(beginWord)) {
            if (map2.get(path).size() > 1) {
                beginSet.add(path);
            }
        }
        Set<String> endSet = new HashSet<>(map1.get(endWord));
        for (String path : map1.get(endWord)) {
            if (map2.get(path).size() > 1) {
                endSet.add(path);
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step ++;
            Set<String> tempSet = new HashSet<>();
            for (String path : beginSet) {
                if (endSet.contains(path)) {
                    return step;
                }
                Set<String> nextWords = map2.get(path);
                if (nextWords != null) {
                    for (String nextWord : nextWords) {
                        if (!visited.contains(nextWord)) {
                            visited.add(nextWord);
                            for (String nextPath : map1.get(nextWord)) {
                                if (map2.get(nextPath).size() > 1) {
                                    tempSet.add(nextPath);
                                }
                            }
                        }
                    }
                }
            }
            beginSet = endSet;
            endSet = tempSet;
        }

        return 0;
    }

    // 双向BFS 超出时间限制
    private int path4(String beginWord, String endWord, List<String> wordList) {
        // abc -> *bc, a*c, ab*
        Map<String, Set<String>> map1 = new HashMap<>(wordList.size());
        // *bc -> abc, bbc, cbc
        Map<String, Set<String>> map2 = new HashMap<>(wordList.size() * 3);

        for(String word : wordList) {
            fillSetMap(map1, map2, word);
        }
        fillSetMap(map1, map2, beginWord);

        if (!map1.containsKey(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        fillNextLevelSet(map1, map2, beginSet, beginWord);
        Set<String> endSet = new HashSet<>();
        fillNextLevelSet(map1, map2, endSet, endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            System.out.println(beginSet);
            System.out.println(endSet);
            System.out.println();

            step ++;
            Set<String> tempSet = new HashSet<>();

            for (String path : beginSet) {
                if (endSet.contains(path)) {
                    return step;
                }

                for (String word : map2.get(path)) {
                    for (String nextPath : map1.get(word)) {
                        if (!path.equals(nextPath)) {
                            tempSet.add(nextPath);
                        }
                    }
                }
            }
            beginSet = endSet;
            endSet = tempSet;
        }

        return 0;
    }

    private void fillNextLevelSet(
            Map<String, Set<String>> map1,
            Map<String, Set<String>> map2,
            Set<String> tempSet, String word) {
        for (String nextPath : map1.get(word)) {
            Set<String> words = map2.get(nextPath);
            tempSet.add(nextPath);
        }
    }

    // 双向BFS
    private int path5(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wordMap = new HashMap<>();
        Map<String, List<String>> pathMap = new HashMap<>();

        for(String word : wordList) {
            Set<String> words = new HashSet<>();
            wordMap.put(word, words);
            for (int i = 0; i < word.length(); i++) {
                String path = word.substring(0, i) + '*' + word.substring(i + 1);
                List<String> pathWords = pathMap.get(path);
                if (pathWords == null) {
                    pathWords = new LinkedList<>();
                    pathMap.put(path, pathWords);
                } else {
                    words.addAll(pathWords);
                    for (String nextWord : pathWords) {
                        wordMap.get(nextWord).add(word);
                    }
                }
                pathWords.add(word);
            }
        }

        if (!wordMap.containsKey(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        for (int i = 0; i < beginWord.length(); i++) {
            String pathWord = beginWord.substring(0, i) + '*' + beginWord.substring(i + 1);
            List<String> words;
            if ((words = pathMap.get(pathWord)) != null) {
                beginSet.addAll(words);
            }
        }

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step ++;
            Set<String> temp;
            if (beginSet.size() < endSet.size()) {
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            temp = new HashSet<>();
            for (String word : endSet) {
                if (beginSet.contains(word)) {
                    return step;
                }
                for (String nextWord : wordMap.get(word)) {
                    if (!visited.contains(nextWord)) {
                        temp.add(nextWord);
                    }
                }
            }
            endSet = temp;
        }

        return 0;
    }

    // 双向BFS   当前最优实现 33ms
    private int path6(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wordMap = new HashMap<>();
        Map<String, List<String>> pathMap = new HashMap<>();

        for(String word : wordList) {
            if (word.equals(beginWord)) {
                continue;
            }
            Set<String> words = new HashSet<>();
            wordMap.put(word, words);
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char temp = arr[i];
                arr[i] = '*';
                String path = new String(arr);
                arr[i] = temp;
                List<String> pathWords = pathMap.get(path);
                if (pathWords == null) {
                    pathWords = new LinkedList<>();
                    pathMap.put(path, pathWords);
                } else {
                    words.addAll(pathWords);
                    for (String nextWord : pathWords) {
                        wordMap.get(nextWord).add(word);
                    }
                }
                pathWords.add(word);
            }
        }

        if (!wordMap.containsKey(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        char[] arr = beginWord.toCharArray();
        for (int i = 0; i < beginWord.length(); i++) {
            char temp = arr[i];
            arr[i] = '*';
            String pathWord = new String(arr);
            arr[i] = temp;
            List<String> words;
            if ((words = pathMap.get(pathWord)) != null) {
                beginSet.addAll(words);
            }
        }

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step ++;
            Set<String> temp;
            if (beginSet.size() < endSet.size()) {
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            temp = new HashSet<>();
            for (String word : endSet) {
                if (beginSet.contains(word)) {
                    return step;
                }
                for (String nextWord : wordMap.get(word)) {
                    if (!visited.contains(nextWord)) {
                        temp.add(nextWord);
                    }
                }
            }
            endSet = temp;
        }

        return 0;
    }

    // 双向BFS 递归实现
    private int path7(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wordMap = new HashMap<>();
        Map<String, List<String>> pathMap = new HashMap<>();

        for(String word : wordList) {
            Set<String> words = new HashSet<>();
            wordMap.put(word, words);
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char temp = arr[i];
                arr[i] = '*';
                String path = new String(arr);
                arr[i] = temp;
                List<String> pathWords = pathMap.get(path);
                if (pathWords == null) {
                    pathWords = new LinkedList<>();
                    pathMap.put(path, pathWords);
                } else {
                    words.addAll(pathWords);
                    for (String nextWord : pathWords) {
                        wordMap.get(nextWord).add(word);
                    }
                }
                pathWords.add(word);
            }
        }

        if (!wordMap.containsKey(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        char[] arr = beginWord.toCharArray();
        for (int i = 0; i < beginWord.length(); i++) {
            char temp = arr[i];
            arr[i] = '*';
            String pathWord = new String(arr);
            arr[i] = temp;
            List<String> words;
            if ((words = pathMap.get(pathWord)) != null) {
                beginSet.addAll(words);
            }
        }

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(endWord);

        return getStep(wordMap, beginSet, endSet, visited, 1);
    }

    private int getStep(Map<String, Set<String>> wordMap,
                        Set<String> beginSet, Set<String> endSet,
                        Set<String> visited, int step) {

        Set<String> temp = new HashSet<>();
        for (String word : endSet) {
            if (beginSet.contains(word)) {
                return step + 1;
            }
            for (String nextWord : wordMap.get(word)) {
                if (!visited.contains(nextWord)) {
                    temp.add(nextWord);
                }
            }
        }
        if (temp.isEmpty()) {
            return 0;
        }

        if (beginSet.size() < temp.size()) {
            endSet = beginSet;
            beginSet = temp;
        } else {
            endSet = temp;
        }

        return getStep(wordMap, beginSet, endSet, visited, step + 1);
    }

    // 双向BFS 使用 meets
    private int path8(String beginWord, String endWord, List<String> wordList) {
        // abc -> *bc, a*c, ab*
        Map<String, Set<String>> map1 = new HashMap<>(wordList.size());
        // *bc -> abc, bbc, cbc
        Map<String, Set<String>> map2 = new HashMap<>(wordList.size() * 3);

        for (String word : wordList) {
            fillSetMap(map1, map2, word);
        }
        fillSetMap(map1, map2, beginWord);

        if (!map1.containsKey(endWord)) {
            return 0;
        }

        Set<String> meets = new HashSet<>(wordList);

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step ++;
            Set<String> tempSet = new HashSet<>();
            meets.removeAll(beginSet);
            for (String word : beginSet) {
                for (String path: map1.get(word)) {
                    for (String nextWord : map2.get(path)) {
                        if (meets.contains(nextWord)) {
                            if (endSet.contains(nextWord)) {
                                return step;
                            }
                            tempSet.add(nextWord);
                        }
                    }
                }
            }
            if (endSet.size() < tempSet.size()) {
                beginSet = tempSet;
            } else {
                beginSet = endSet;
                endSet = tempSet;
            }
        }

        return 0;
    }

    private void fillSetMap(Map<String, Set<String>> map1, Map<String, Set<String>> map2, String word) {
        Set<String> paths = map1.computeIfAbsent(word, k -> new HashSet<>());
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char temp = arr[i];
            arr[i] = '*';
            String pathWord = String.valueOf(arr);
            arr[i] = temp;
            paths.add(pathWord);
            map2.computeIfAbsent(pathWord, k -> new HashSet<>()).add(word);
        }
    }

    // 双向BFS 使用 meets  按字符遍历
    private int path9(String beginWord, String endWord, List<String> wordList) {
        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) {
            return 0;
        }

        int length = beginWord.length();

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step ++;
            Set<String> tempSet = new HashSet<>();
            meets.removeAll(beginSet);
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < length; i++) {
                    char temp = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (temp == j) {
                            continue;
                        }
                        arr[i] = j;
                        String nextWord = String.valueOf(arr);
                        if (meets.contains(nextWord)) {
                            if (endSet.contains(nextWord)) {
                                return step;
                            }
                            tempSet.add(nextWord);
                        }
                    }
                    arr[i] = temp;
                }
            }
            if (endSet.size() < tempSet.size()) {
                beginSet = tempSet;
            } else {
                beginSet = endSet;
                endSet = tempSet;
            }
        }

        return 0;
    }



    // 双向BFS
    private int path10(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wordMap = new HashMap<>();
        Map<String, List<String>> pathMap = new HashMap<>();

        for(String word : wordList) {
            Set<String> words = new HashSet<>();
            wordMap.put(word, words);
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char temp = arr[i];
                arr[i] = '*';
                String path = new String(arr);
                arr[i] = temp;
                List<String> pathWords = pathMap.get(path);
                if (pathWords == null) {
                    pathWords = new LinkedList<>();
                    pathMap.put(path, pathWords);
                } else {
                    words.addAll(pathWords);
                    for (String nextWord : pathWords) {
                        wordMap.get(nextWord).add(word);
                    }
                }
                pathWords.add(word);
            }
        }

        if (!wordMap.containsKey(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        char[] arr = beginWord.toCharArray();
        for (int i = 0; i < beginWord.length(); i++) {
            char temp = arr[i];
            arr[i] = '*';
            String pathWord = new String(arr);
            arr[i] = temp;
            List<String> words;
            if ((words = pathMap.get(pathWord)) != null) {
                beginSet.addAll(words);
            }
        }

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> meets = new HashSet<>(wordList);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            step ++;
            Set<String> temp = new HashSet<>();
            for (String word : endSet) {
                if (beginSet.contains(word)) {
                    return step;
                }
                meets.remove(word);
                for (String nextWord : wordMap.get(word)) {
                    if (meets.contains(nextWord)) {
                        temp.add(nextWord);
                    }
                }
            }

            if (temp.size() > beginSet.size()) {
                endSet = temp;
            } else {
                endSet = beginSet;
                beginSet = temp;
            }
        }

        return 0;
    }

    private int path11(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord)) return 0;
        return bfs(start, end, dic, 2);
    }

    private int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
        //双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
        if (st.size() == 0) return 0;
        if (st.size() > ed.size()) {//双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
            return bfs(ed, st, dic, l);
        }
        //BFS的标记行为，即使用过的不重复使用
        dic.removeAll(st);
        //收集下一层临近点
        HashSet<String> next = new HashSet<>();
        for (String s : st) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) continue;
                    arr[i] = c    ;
                    String nstr = new String(arr);
                    if (dic.contains(nstr)) {
                        if (ed.contains(nstr)) return l;
                        else next.add(nstr);
                    }
                }
                arr[i] = tmp;
            }
        }
        return bfs(next, ed, dic, l + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
