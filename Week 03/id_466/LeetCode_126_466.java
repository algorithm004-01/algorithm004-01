//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回一个空列表。
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
// Related Topics 广度优先搜索 数组 字符串 回溯算法
package com.aseara.leetcode.editor.cn.a126;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * desc: 126.单词接龙 II <br />
 * Date: 2019/11/3 <br/>
 *
 * @author qiujingde
 */
class WordLadderIi {
    private Solution solution = new Solution();

    @Test
    void test1() {
        String begin = "hit";
        String end = "cog";
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
        Set<List<String>> expected = new HashSet<>(Arrays.asList(
                Arrays.asList("hit","hot","lot","log","cog"),
                Arrays.asList("hit","hot","dot","dog","cog")));

        assertIterableEquals(expected, new HashSet<>(solution.path2(begin, end, dict)));

        // [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
        begin = "red";
        end = "tax";
        dict = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        expected = new HashSet<>(Arrays.asList(
                Arrays.asList("red","ted","tad","tax"),
                Arrays.asList("red","ted","tex","tax"),
                Arrays.asList("red","rex","tex","tax")));

        assertIterableEquals(expected, new HashSet<>(solution.path2(begin, end, dict)));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return path2(beginWord, endWord, wordList);
    }


    List<List<String>> path1(String beginWord, String endWord, List<String> wordList) {

        return Collections.emptyList();
    }




    List<List<String>> path2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return Collections.emptyList();
        }

        Map<String, LinkedList<LinkedList<String>>> travelSet = new HashMap<>();
        travelSet.put(beginWord, new LinkedList<>());
        travelSet.get(beginWord).add(new LinkedList<>(Collections.singleton(beginWord)));
        Map<String, LinkedList<LinkedList<String>>> checkSet = new HashMap<>();
        checkSet.put(endWord, new LinkedList<>());
        checkSet.get(endWord).add(new LinkedList<>(Collections.singleton(endWord)));

        return bfs1(dict, travelSet, checkSet, true);
    }

    private List<List<String>> bfs1(Set<String> dict,
                                    Map<String, LinkedList<LinkedList<String>>> travelSet,
                                    Map<String, LinkedList<LinkedList<String>>> checkSet,
                                    boolean dir) {
        if (travelSet.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, LinkedList<LinkedList<String>>> nextSet = new HashMap<>();

        List<List<String>> result = null;

        for (Map.Entry<String, LinkedList<LinkedList<String>>> node : travelSet.entrySet()) {
            String word = node.getKey();
            dict.remove(word);
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char temp = arr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (temp == j) {
                        continue;
                    }
                    arr[i] = j;
                    String next = String.valueOf(arr);
                    arr[i] = temp;

                    if (checkSet.containsKey(next)) {
                        if (result == null) {
                            result = new LinkedList<>();
                        }
                        result.addAll(getPath(node.getValue(), checkSet.get(next), dir));


                    } else if (dict.contains(next)){
                        LinkedList<LinkedList<String>> paths =
                                nextSet.computeIfAbsent(next, k -> new LinkedList<>());
                        for (LinkedList<String> path : node.getValue()) {
                            LinkedList<String> newPath = new LinkedList<>(path);
                            newPath.add(next);
                            paths.add(newPath);
                        }
                    }
                }
            }
        }

        if (result != null) {
            return result;
        }

        if (nextSet.size() >= checkSet.size()) {
            return bfs1(dict, nextSet, checkSet, dir);
        } else {
            return bfs1(dict, checkSet, nextSet, !dir);
        }
    }

    private List<LinkedList<String>> getPath(LinkedList<LinkedList<String>> head,
                                             LinkedList<LinkedList<String>> tail,
                                             boolean dir) {
        if (dir) {
            System.out.println(head);
            System.out.println(tail);
            List<LinkedList<String>> paths = new LinkedList<>();
            for (LinkedList<String> headP : head) {
                for (LinkedList<String> tailP : tail) {
                    paths.add(getPath(headP, tailP));
                }
            }
            System.out.println(paths);
            System.out.println();
            return paths;
        }
        return getPath(tail, head, true);
    }

    private LinkedList<String> getPath(LinkedList<String> head,
                                       LinkedList<String> tail) {
        LinkedList<String> path = new LinkedList<>(head);

        Iterator<String> iter = tail.descendingIterator();
        while (iter.hasNext()) {
            path.add(iter.next());
        }

        return path;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
