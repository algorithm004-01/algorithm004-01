import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */
// @lc code=start
class Solution {
    //直接bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        //预处理数据
        HashMap<String,ArrayList<String>> dict = new HashMap<>();
        wordList.forEach(word->{
            for(int i = 0; i < L; i++){
                String newWord = word.substring(0,i) + "*" + word.substring(i+1,L);
                ArrayList<String> dicts = dict.getOrDefault(newWord, new ArrayList<>());
                dicts.add(word);
                dict.put(newWord, dicts);
            }
        });

        //BFS使用的queue
        // Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Queue<Pair<String,Integer>> q = new LinkedList<Pair<String, Integer>>();
        q.add(new Pair<>(beginWord, 1));
        //visited,访问过数据
        HashMap<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        //开始bfs遍历
        while(!q.isEmpty()){
            Pair<String,Integer> p = q.poll();
            String word = p.getKey();
            Integer level = p.getValue();

            for(int i = 0; i < L; i++){
                String newWord = word.substring(0,i) + "*" + word.substring(i+1, L);
                //如果找到，跟上一级单词差距为1
                for(String item : dict.getOrDefault(newWord,new ArrayList<>())){
                    if(item.equals(endWord)){
                        return level + 1;
                    }
                    if(!visited.containsKey(item)){
                        visited.put(item, true);
                        q.offer(new Pair<>(item,level +1));
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end

