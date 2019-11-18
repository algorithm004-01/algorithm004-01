import java.util.*;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-10-29 10:09
 **/

public class Leetcode_433_371 {
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int i = minMutation(start, end, bank);
        System.out.println("i = " + i);
    }

    /**
     * 仿解1:单向 BFS<===(如何转化成单向 BFS的问题的?差1个字符就是1度关系,差2个字符就是2度关系,依次将当前顶点的一度关系加入队列)
     *
     * @return
     */
    public static int minMutation(String start, String end, String[] bank) {
        //0.边界情况处理
        if (start.isEmpty() || end.isEmpty() || bank ==null|| bank.length == 0) return -1;

        if (start.equals(end)) return 0;


        //1.定义是否访问过该节点
        Set<String> visited = new HashSet<>();
        //2.创建队列
        Queue<String> queue = new LinkedList<>();
        //3.将起点加入队列
        queue.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int count = queue.size(); //确定每次 BFS 的宽度
            for (int i = 0; i < count; i++) {
                String curr = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    int diff = 0;//注意 diff 的作用域
                    if (!visited.contains(bank[j])) {//当前节点未被访问
                        String bankStr = bank[j];
                        for (int k = 0; k < curr.length(); k++) {
                            if (curr.charAt(k) != bankStr.charAt(k)) diff++;
                        }
                        if (diff == 1) {
                            //判断是否是end
                            if (bankStr.equals(end)) return step;
                            visited.add(bank[j]);//标记该节点已经访问
                            queue.add(bankStr);
                        }
                    }
                }
            }
        }
        return -1;
    }
}













