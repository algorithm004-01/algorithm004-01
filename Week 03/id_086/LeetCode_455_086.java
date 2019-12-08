# 455 分发饼干
# 寻找两个数组中想匹配的元素并返回

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int biscuit = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (child < g.length && biscuit < s.length) {
            if (g[child] <= s[biscuit]) {
                child ++;
            }
            biscuit ++;
        }
        return child;
    }
}