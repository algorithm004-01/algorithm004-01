/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_416{
    /**
     * BFS：广度优先搜索
     * @param n
     * @return
     */
    public  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(null == wordList) return 0;
        int len = beginWord.length();
        Map<String,List<String>> allDict = new HashMap<>();
        //改变形态，用HashMap散列表模拟二叉树形态
        wordList.forEach(word -> {
            for(int i = 0;i < len;i++) {
                String commonStatus = word.substring(0,i)+ "*" + word.substring(i+1,len);
                if(!allDict.containsKey(commonStatus)) {
                    allDict.put(commonStatus,new ArrayList<>());
                }
                allDict.get(commonStatus).add(word);
            }
        });
        Queue<javafx.util.Pair<String,Integer>> q = new LinkedList<>();
        q.offer(new javafx.util.Pair(beginWord,0));
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        while (!q.isEmpty()) {
            javafx.util.Pair<String,Integer> cur =  q.poll();
            String curWord = cur.getKey();
            Integer level = cur.getValue();
            if(curWord.equals(endWord)) {
                return level + 1;
            }
            for(int i = 0;i < len;i++) {
                String commonStatus = curWord.substring(0,i)+ "*" + curWord.substring(i+1,len);
                List<String> curCommonStatus = allDict.get(commonStatus);
                if(null != curCommonStatus && curCommonStatus.size() > 0 ) {
                    curCommonStatus.forEach(str -> {
                        if (!visited.containsKey(str)) {
                            visited.put(str, true);
                            q.offer(new javafx.util.Pair(str,level + 1));
                        }
                    });
                }
            }
        }
        return 0;
    }
}