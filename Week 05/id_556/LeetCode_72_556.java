import java.util.ArrayList;
import java.util.List;

public class EditDistance72 {
    public static void main(String[] args) {
        EditDistance72 editDistance72 = new EditDistance72();
//        System.out.println(editDistance72.minDistance("horse", "ros"));
        System.out.println(editDistance72.minDistance2("intention", "execution"));
        // !!! ArrayIndexOutOfBoundsException to be resolve
//        editDistance72.minSequence("intention", "execution").forEach(System.out::println);
        editDistance72.minSequence("horse", "ros").forEach(System.out::println);
    }

    // 1. recursive brutal force (top-down)
    public int minDistance(String word1, String word2) {
        return dp(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    private int dp(int i, int j, String word1, String word2) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(i - 1, j - 1, word1, word2);
        } else {
            int insert = dp(i, j - 1, word1, word2) + 1;
            int delete = dp(i - 1, j, word1, word2) + 1;
            int replace = dp(i - 1, j - 1, word1, word2) + 1;
            return Math.min(insert, Math.min(delete, replace));
        }
    }

    // 2. memoization (bottom up)
    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // only one char, to delete
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    // 3. get the edit sequence
    class Node {
        int distance;
        int operation; // 0: skip 1: insert 2:delete 3: replace

        Node(int distance, int operation) {
            this.distance = distance;
            this.operation = operation;
        }
    }

    public List<Integer> minSequence(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            nodes.add(new ArrayList<Node>(n + 1));
        }

        for (int i = 0; i <= m; i++) {
            Node node = new Node(i, 2);
            nodes.get(i).add(0, node);
        }
        for (int j = 0; j <= n; j++) {
            Node node = new Node(j, 2);
            nodes.get(0).add(j, node);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    int t = nodes.get(i - 1).get(j - 1).distance;
                    Node node = new Node(t, 0);
                    nodes.get(i).add(j, node);
                } else {
                    int insert = nodes.get(i).get(j - 1).distance + 1;
                    int delete = nodes.get(i - 1).get(j).distance + 1;
                    int replace = nodes.get(i - 1).get(j - 1).distance + 1;
                    int min = Math.min(insert, Math.min(delete, replace));
                    int oper = 0;
                    if (min == insert) {
                        oper = 1;
                    } else if (min == delete) {
                        oper = 2;
                    } else if (min == replace) {
                        oper = 3;
                    }
                    Node node = new Node(min, oper);
                    nodes.get(i).add(j, node);
                }
            }
        }

        // print the operations
        List<Integer> operations = new ArrayList<>();
        Node lastNode = nodes.get(m).get(n);
        for (int i = m; i > 0; ) {
            for (int j = n; j > 0; ) {
                int operation = lastNode.operation;
                if (operation > 0) {
                    operations.add(operation);
                }
                if (operation == 1) {
                    lastNode = nodes.get(i).get(j--);
                } else if (operation == 2) {
                    lastNode = nodes.get(i--).get(j);
                } else if (operation == 0 || operation == 3) {
                    lastNode = nodes.get(i--).get(j--);
                }
            }
        }
        return operations;
    }
}
