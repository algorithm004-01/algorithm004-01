class Solution {
    public List<List<String>> solveNQueens(int n) {
        int col[] = new int[n];
        int line1[] = new int[2 * n];
        int line2[] = new int[2 * n];
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        dfs(n, 0, col, line1, line2, result, results);
        return results;
    }

    public void dfs(int n, int row, int colLine[], int[] line1, int[] line2, List<String> result, List<List<String>> results) {
        if (result.size() == n) {
            results.add(new ArrayList<>(result));
            return;
        }

        char[] s = new char[n];
        Arrays.fill(s, '.');
        for (int col = 0; col < s.length; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (colLine[col] == 0 && line1[id1] == 0 && line2[id2] == 0) {
                colLine[col] = 1;
                line1[id1] = 1;
                line2[id2] = 1;
                s[col] = 'Q';
                result.add(new String(s));
                dfs(n, row + 1, colLine, line1, line2, result, results);
                s[col] = '.';
                result.remove(result.size() - 1);
                colLine[col] = 0;
                line1[id1] = 0;
                line2[id2] = 0;
            }
        }
    }
}