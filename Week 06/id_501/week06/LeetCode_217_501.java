package homework.week06;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder
 * @author tangxy
 * @date 2019-11-24
 */
public class LeetCode_217_501 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        int n = beginWord.length();
        Map<String,List<String>> allCommons = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < n; i++) {
                String common = word.substring(0,i) + "*" + word.substring(i + 1);
                if(!allCommons.containsKey(common)){
                    allCommons.put(common,new ArrayList<>());
                }
                allCommons.get(common).add(word);
            }
        });
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        Set<String> visited = new HashSet<>();
        int len = 1;
        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size() > end.size()){
                Set<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            Set<String> neighbor = new HashSet<>();
            for (String cur : begin) {
                for (int i = 0; i < n; i++) {
                    String tmp = cur.substring(0,i) + "*" + cur.substring(i+1);
                    if(!allCommons.containsKey(tmp)){
                        continue;
                    }
                    for (String str : allCommons.get(tmp)) {
                        if(end.contains(str)){
                            return len + 1;
                        }
                        if(!visited.contains(str)){
                            visited.add(str);
                            neighbor.add(str);
                        }
                    }
                }
            }
            begin =neighbor;
            len ++;
        }
        return 0;
    }

}
