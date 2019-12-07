import java.util.Arrays;

public class UniquePaths {

    /*
     * 暴力解法：
     * 从 左上角 开始， 他只有两种走法，一种向下，一种向右
     * 直到走到 右下角
     */
    public static int uniquePaths(int m, int n) {
        return _uniquePaths(0, 0, m, n);
    }

    public static int _uniquePaths(int x, int y, int m, int n) {
        if (x >= m || y >= n) return 0;
        if (x == m - 1 && y == n - 1) return 1;

        return _uniquePaths(x + 1, y, m, n) + _uniquePaths(x, y + 1, m, n);
    }

    //递推公式 F(m, n) = F(m - 1, n) + F(m, n - 1)
    //我们假设 m 代表的是 X 轴，n 代表的是 Y 轴
    public static int uniquePaths_2(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = m - 1; j >= 0; j--)
                if (j == m - 1)
                    dp[j] = 1;
                else
                    dp[j] = dp[j] + dp[j + 1];
        return dp[0];
    }

    public static int uniquePathOfficial(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(23, 12));
        System.out.println(uniquePaths_2(23, 12));



    }
}