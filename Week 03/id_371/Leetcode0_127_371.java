import java.util.*;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-29 22:22
 **/

public class Leetcode0_127_371 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int i = ladderLength3(beginWord, endWord, wordList);
        System.out.println("i = " + i);
    }


    /**
     * 仿解2:(双向 BFS 优化:优化掉了 visited;以前的思路是记录访问的节点,现在是直接删除访问的节点,而下一轮要遍历的一度关系节点都已经保存在beginSet 容器合 endSet 容器中了)
     *
     * @author Shaobo.Qian
     * @date 2019/10/30
     */
    public static int ladderLength3(String beginWord, String endWord, List<String> wordAsList) {
        //0.边界处理
        if (!wordAsList.contains(endWord)) return 0;
        //1.定义容器,变量
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordList = new HashSet<>(wordAsList);
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        wordList.remove(beginWord);
        wordList.remove(endWord);
        //2.每次选择较小的那一层,对该层进行遍历
        while (!beginSet.isEmpty()) {
            step++;
            Set<String> nextSet = new HashSet<>();
            //3.对当前层节点进行遍历
            for (String currWord : beginSet) {
                char[] chars = currWord.toCharArray();
                for (int i = 0; i < currWord.length(); i++) {

                    for (char c = 'a'; c < 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String targetStr = String.valueOf(chars);
                        if (endSet.contains(targetStr)) return step;
                        if (wordList.contains(targetStr)) {
                            //4.生成下一层元素
                            nextSet.add(targetStr);
                            wordList.remove(targetStr);
                        }
                        chars[i] = old;
                    }
                }
            }

            beginSet = nextSet.size() < endSet.size() ? nextSet : endSet;
            endSet = beginSet.size() < endSet.size() ? endSet : nextSet;
        }
        return 0;
    }

    /**
     * 仿解1:(双向 BFS)
     *
     * @author Shaobo.Qian
     * @date 2019/10/30
     */
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //0.边界处理
        if (!wordList.contains(endWord)) return 0;
        //1.定义容器,变量
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 0;
        //2.每次选择较小的那一层,对该层进行遍历
        while (!beginSet.isEmpty()) {
            step++;
            if (endSet.size() < beginSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> tempSet = new HashSet<>();
            //3.对当前层节点进行遍历
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c < 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String targetStr = String.valueOf(chars);
                        if (endSet.contains(targetStr)) return step + 1;
                        if (!visited.contains(targetStr) && wordList.contains(targetStr)) {
                            visited.add(targetStr);
                            tempSet.add(targetStr);
                        }
                        chars[i] = old;
                    }
                }
            }

            beginSet = tempSet;
        }
        return 0;
    }


    /**
     * 原解1:最短路径问题(BFS)
     *
     * @author Shaobo.Qian
     * @date 2019/10/30
     */
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        //0.边界处理
        if (wordList == null || wordList.size() == 0) return 0;
        if (!wordList.contains(endWord)) return 0;
        //1.创建各种容器
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            //2.确定每次BFS 的宽度
            int count = queue.size();
            while (count-- > 0) {
                //3.处理当前节点
                String curr = queue.poll();
                if (!visited.contains(curr)) {
                    visited.add(curr);
                    for (String wordStr : wordList) {
                        int diff = 0;
                        for (int i = 0; i < curr.length(); i++) {
                            if (curr.charAt(i) != wordStr.charAt(i)) diff++;
                        }
                        if (diff == 1) {
                            //4.找到新节点,放入队列
                            if (endWord.equals(wordStr)) return step + 1;
                            queue.add(wordStr);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
