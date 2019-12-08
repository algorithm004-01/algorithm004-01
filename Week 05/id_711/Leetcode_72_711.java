package Week5;

public class Leetcode_72_711 {
    public static void main(String[] args) {
        String word1 = "";
        String word2 = "a";
        System.out.println(minDistance(word1,word2));
    }

    /**
     * 自己想出来的解法，nice，看了题解，和题解做法差不多，nice
     * f[i][j]表示word1以第i个字符结尾的子串和word2第j个字符结尾的子串的最小编辑距离
     * f[i][j] = min(f[i][j - 1], f[i - 1][j], f[i - 1][j - 1]) + 1;
     * if (word1[i] == word2[j]) f[i][j] = min(f[i - 1][j - 1], f[i][j]);
     * @param word1
     * @param word2
     * @return
     */
    private static int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(Math.min(f[i][j - 1], f[i - 1][j]),f[i - 1][j - 1]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i - 1][j - 1], f[i][j]);
                }
            }
        }
        return f[n][m];
    }
}
