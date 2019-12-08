import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-01 17:54
 **/

public class Leetcode_403_371 {
    public static void main(String[] args) {
//        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        boolean can = canCross(stones);
        System.out.println("can = " + can);
    }

    /**
     * 防解2:dfs
     * @author Shaobo.Qian
     * @date 2019/12/1
     * @link https://leetcode.com/problems/frog-jump/discuss/88804/JAVA-DFS-17ms-beat-99.28-so-far
     */
    public static boolean canCross2(int[] stones) {
        return false;
    }
    /**
     * 防解1:循环+map
     *
     * @author Shaobo.Qian
     * @date 2019/12/1
     * @link https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations
     */
    public static boolean canCross1(int[] stones) {
        if (stones.length == 0) return true;
        //记录在每一个节点可以走的所有可能得的数
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        int len = stones.length;
        for (int i = 1; i < len; i++) {
            map.put(stones[i], new HashSet<>());
        }
        for (int i = 0; i < len; i++) {
            int stone = stones[i];
            HashSet<Integer> set = map.get(stone);

            for (Integer step : set) {
                int reach = stone + step;//从当前 stone 位置走 step可以达到的位置
                if (reach == stones[len - 1]) return true;
                HashSet<Integer> nextSet = map.get(reach);
                if (nextSet != null) {//说明能到达的位置有石头
                    nextSet.add(step);
                    if(step-1>0) nextSet.add(step - 1);
                    nextSet.add(step + 1);
                }
            }
        }
        return false;
    }

    /**
     * 原解(未通过,没有看清题意)
     *
     * @author Shaobo.Qian
     * @date 2019/12/1
     */
    public static boolean canCross(int[] stones) {

        //确定的上一部跳跃的单位
        int k = 1;
        for (int i = 2; i < stones.length; i++) {
            if (Math.abs(stones[i] - stones[i - 1] - k) > 1) return false;
            k = stones[i] - stones[i - 1];
        }

        return true;
    }
}
