package greedy;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
 * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，
 * 都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 思路：
 * 1. 给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来满足满足度比较大的孩子
 * 2. 因为满足度最小的孩子最容易满足，所以先满足满足度最小的孩子
 * 最优：尽量多的孩子分到饼干，那么每个孩子的饼干最接近其满足度
 */
public class LC_455_AssignCookie {

    /**
     * 满足孩子，胃口最小的孩子，优先满足，并且使用最靠近的饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, sj = 0;
        while (gi < g.length && sj < s.length) {
            if (g[gi] <= s[sj]) {
                // 当前最优解，用最小饼干满足小孩子最小的胃口
                gi++;
            }
            sj++;
        }
        return gi;
    }
}
