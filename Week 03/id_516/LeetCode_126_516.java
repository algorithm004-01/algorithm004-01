package cn.jomoon.nov03;

import java.util.*;

public class LeetCode126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> meets = new HashSet<>(wordList);
        if (!meets.contains(endWord)) return Collections.emptyList();
        Set<String> begin = new HashSet<>(Collections.singleton(beginWord));
        Set<String> end = new HashSet<>(Collections.singleton(endWord));

        Map<String,List<String>> neighborsMap = new HashMap<>();
        if (!doubleDfs(begin,end,neighborsMap,true,meets)) return Collections.emptyList();

        List<List<String>> result = new ArrayList<>();
        dfs(neighborsMap,result,beginWord,endWord,new LinkedList<>());
        return result;
    }


    private boolean doubleDfs(Set<String> begin, Set<String> end, Map<String, List<String>> neighborsMap, boolean isFromBeginToEnd, Set<String> meets) {
        if (begin.size() == 0) return false;

        meets.removeAll(begin);

        boolean isMeetInCurrLevel = false;

        Set<String> nextLevels = new HashSet<>();

        for (String beginWord : begin) {
            char[] arr = beginWord.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char swap = arr[i];
               for (char j = 'a'; j <= 'z'; j++) {
                   arr[i] = j;
                   String newWord = String.valueOf(arr);
                   if (!meets.contains(newWord)) continue;

                   nextLevels.add(newWord);

                   String key = isFromBeginToEnd ? newWord : beginWord;
                   String neighbor = isFromBeginToEnd ? newWord : beginWord;
                   if (!neighborsMap.containsKey(key)) neighborsMap.put(key,new ArrayList<>());
                   neighborsMap.get(key).add(neighbor);

                   if (end.contains(newWord)) isMeetInCurrLevel = true;
               }
               arr[i] = swap;
            }
        }

        if (isMeetInCurrLevel) return true;

        if (nextLevels.size() > end.size()) return doubleDfs(end,nextLevels,neighborsMap,!isFromBeginToEnd,meets);
        else return doubleDfs(nextLevels,end,neighborsMap,isFromBeginToEnd,meets);
    }

    private void dfs(Map<String, List<String>> neighborsMap, List<List<String>> res, String beginWord, String endWord, Deque<String> path) {
        if (res.size() > 0 && path.size() == 0) return;
        path.addLast(beginWord);

        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        } else if (neighborsMap.containsKey(beginWord)) {
            for (String neighbor : neighborsMap.get(beginWord)) {
                dfs(neighborsMap,res,neighbor,endWord,path);
            }
        }

        path.removeLast();
    }




}
