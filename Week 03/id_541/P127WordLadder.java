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

package leetcode.editor.cn;

import java.util.*;

//Java：单词接龙
public class P127WordLadder{
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        int a = solution.ladderLength("hit","cog", Arrays.asList(wordList));
        System.out.println(a);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //hit cog
//        wordList = ["hot","dot","dog","lot","log","cog"]
        //hit -> %s i t -> 0
//            -> h %s t -> hot -> -> %s o t -> lot/hot/hot -> log1 / lot2 /  cog
//            -> h i %s -> 0      -> h %s t -> hot
//                                -> h o %s -> hot

        int length = beginWord.length();
        int L = beginWord.length();
        Map<String,List<String>> mapping = new HashMap<String, List<String>>();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
        Map<String,Boolean> visited = new HashMap<String, Boolean>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });
        //利用queue来进行广度优先遍历
        Queue<LevelNode> queue = new LinkedList();
        queue.offer(new LevelNode(beginWord,1));
        while(!queue.isEmpty()){
            LevelNode word = queue.poll();
            for (int i = 0; i < length; i++) {
                String key = word.node.substring(0,i) + "*" +  word.node.substring(i+1,length);
                if (visited.getOrDefault(key,false)){
                    continue;
                }
                List<String> subWord = allComboDict.getOrDefault(key,new ArrayList<>());
                for (String str : subWord) { //二级子节点
                    if (str.equals(endWord)){
                        return word.level+1;
                    }
                    if (!visited.getOrDefault(str,false)){
                        visited.put(str,true);
                        queue.offer(new LevelNode(str,word.level+1));
                    }
                }
                visited.put(key,true);
            }
        }
        return 0;
    }

    class LevelNode{
        private String node;
        private int level;

        public LevelNode(String node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}