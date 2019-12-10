package medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/10/31
 */
public class MinimumGeneticMutation {

    /**
     * 使用广度优先搜索
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>(bank.length);
        int level = 0; //突变次数
        for (String b : bank) bankSet.add(b);
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        //设置队列存储值
        Deque<String> deque = new LinkedList<>();
        //访问的数组
        Set<String> visited = new HashSet<>();
        //设置初始值
        deque.addLast(start);
        visited.add(start);
        //广度优先遍历
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String str = deque.removeFirst();
                //如果与最后的基因相等，直接返回
                if (str.equals(end)) return level;
                char[] charArray = str.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char old = charArray[i];
                    for (char c : chars) {
                        charArray[i] = c;
                        String newStr = new String(charArray);
                        // 如果当前不是访问过的且在基因库中，进行存放
                        if (!visited.contains(newStr) && bankSet.contains(newStr)) {
                            deque.addLast(newStr);
                            visited.add(newStr);
                        }
                    }
                    charArray[i] = old; //还原
                }
            }
            level++;
        }
        return -1;
    }
}
