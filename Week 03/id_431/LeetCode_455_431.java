package easy;

import java.util.Arrays;

/**
 * @author 潘磊明
 * @date 2019/11/4
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int children = 0;
        // 对数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        for (;i < g.length; i++) {
            for (; j < s.length; j++){
                if (j > s.length - 1) return children;
                if (s[j] >= g[i]) {children++; j++; break;}
            }
        }
        return children;
    }
}
