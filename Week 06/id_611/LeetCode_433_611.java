import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = new String[]{"AACCGGTA","AACCGGTC"};
        minMutation(start, end, bank);


    }

    public static int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        for(String b :bank) bankSet.add(b);

        char[] chars = new char[]{'A','C','G','T'};
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String cur = queue.poll();
                if(cur.equals(end)) return level;

                char[] charArr = cur.toCharArray();
                for(int i = 0; i < charArr.length; i++){
                    char old = charArr[i];
                    for(int c =0; c < chars.length; c++){
                        charArr[i] = chars[c];
                        String next = new String(charArr);
                        if(!visited.contains(next) && bankSet.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    charArr[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}