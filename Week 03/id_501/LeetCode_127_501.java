package homework.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

/**
 * 127. 单词接龙 https://leetcode-cn.com/problems/word-ladder/description/
 */
public class LeetCode_127_501{
    /**
     * 思路：
     * 1、预处理，把单词表中所有改变一次后的相同的单词关联起来。dog dig 都对应d*g
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
           return 0; 
        }
        int L = beginWord.length();
        Map<String,List<String>> dic = new HashMap<>();

        // 预处理
        for(String word : wordList){
            for(int i = 0;i < L; i++){
                String newWord = word.substring(0,i) + '*' + word.substring(i + 1,L); 
                List<String> formatList = dic.getOrDefault(newWord, new ArrayList<>());
                formatList.add(word);
                dic.put(newWord, formatList);
            }
        }

        // bfs
        Queue<Pair<String,Integer>> Q = new LinkedList<Pair<String,Integer>>();
        Q.add(new Pair(beginWord,1));

        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!Q.isEmpty()){
            Pair<String,Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i = 0;i < L;i++){
                String newWord = word.substring(0,i) + '*' + word.substring(i + 1,L); 
                for(String adjacentWord : dic.getOrDefault(newWord, new ArrayList<String>())){
                    if(adjacentWord.equals(endWord)){
                        return level + 1;
                    }
                    if(!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord, true);
                        Q.add(new Pair<String,Integer>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        
    }
}