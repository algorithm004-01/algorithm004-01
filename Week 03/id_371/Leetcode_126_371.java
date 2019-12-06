import java.util.*;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-31 07:35
 **/

public class Leetcode_126_371 {
    public static void main(String[] args) {
       String  beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        res.stream().forEach(System.out::println);
    }

    /**
     * 仿解1(BFS+DFS)
     * @author Shaobo.Qian
     * @date 2019/10/31
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //0.处理边界情况
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord)) return result;
        //1.记录每个节点的所有邻居节点
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        //2.记录每个节点到起点的最短路径
        Map<String, Integer> distance = new HashMap<>();

        //从起点到终点的路径
        ArrayList<String> path = new ArrayList<>();
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, path, result);
        return result;
    }

    private static void dfs(String currWord, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, ArrayList<String> path, List<List<String>> result) {
        //1.递归出口(当没有下一层为被访问的节点时,递归结束)
        //2.处理当前层
        path.add(currWord);
        if (endWord.equals(currWord)) {
            result.add(new ArrayList<>(path));
        } else {
            List<String> neighbors = nodeNeighbors.get(currWord);
            for (String nextWord : neighbors) {
                //3.带上参数,去下一层
                if (distance.get(currWord) + 1 == distance.get(nextWord)) {//确保是当前节点的下一层,因为邻点也包括它的父节点
                    dfs(nextWord, endWord, dict, nodeNeighbors, distance, path, result);
                }
            }

        }
        //4.清理当前层数据 ---> 每一条路径在处理完时(只要走完,无论是否找到终点)需要清除, 因为path容器是所有容器共享的
        path.remove(path.size() - 1);
    }

    private static void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<String>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);//起点与起点之间的距离为0
        boolean foundEnd = false; //如果在当前层找到 endstr
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                //获取当前节点
                String curr = queue.poll();
                //起点到当前节点的距离
                int currDistance = distance.get(curr);
                //找到邻居节点(下一层节点),并记录当前节点到起点的最短
                ArrayList<String> neighbors = getNeighbor(curr, dict);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(curr).add(neighbor);
                    if (!distance.containsKey(neighbor)) {//check if visited 该节点
                        distance.put(neighbor, currDistance + 1);
                        if (endWord.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (foundEnd) break;//从当前节点所在层去往终点只有一条路径,所以跳出循环,不需要在当前层找了
            }

        }
    }

    /**
     * 找到当前节点的下一层节点
     *
     * @param curr
     * @param dict
     * @return
     */
    private static ArrayList<String> getNeighbor(String curr, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = curr.toCharArray();
        for (char ch = 'a'; ch < 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (ch == chs[i]) continue;
                char old = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) res.add(String.valueOf(chs));
                chs[i] = old;
            }
        }
        return res;
    }


}
