import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-02 11:28
 **/

public class Leetcode_455_371 {

    public static void main(String[] args) {
//        int[] g = {1, 2,2};
        int[] g = {10,9,8,7};
//        int[] s = {1, 1};
//        int[] s = {1,2,3};
        int[] s = {5,6,7,8};
        int content = findContentChildren1(g, s);
        System.out.println("content = " + content);
    }

    /**
     * 原解1:贪心算法
     *
     * @author Shaobo.Qian
     * @date 2019/11/2
     */
    public static int findContentChildren1(int[] g, int[] s) {
        int content = 0;
        int sLen = s.length;
        Arrays.sort(g);
        //先满足胃口大的
        for (int i = g.length - 1; i >= 0; i--) {
            if (sLen <= 0) return content;
            //边界处理
            if (s[sLen - 1] >= g[i]) {
                content++;
                sLen--;
            }
        }
        return content;
    }

}
