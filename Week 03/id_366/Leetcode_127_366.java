/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), wordList.get(i));
        }
        if ( !map.containsKey(endWord)) return 0;
        //Queue<String> queue = new ArrayList<String>();  ArrayList没有实现Queue
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int ladder = 1;
        while (queue.size() != 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String processWord = queue.poll();
                char[] chars = processWord.toCharArray();
                if(processWord.equals(endWord)){
                    return ladder;
                }
                map.remove(processWord);
                for (int j = 0; j < chars.length; j++) {
                    char currentChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String temp = String.valueOf(chars);
                        if (map.containsKey(temp) && map.get(temp) != endWord) {
                            queue.offer(temp);
                        }  
                    }
                    chars[j] = currentChar;
                }
            }
            ladder ++;
        }
        return 0;
    }
}
// @lc code=end

