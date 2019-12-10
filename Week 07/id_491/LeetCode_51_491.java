class Solution {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] row = new int[n];
        int lie = 0;
        int pie = 0;
        int na = 0;
        recursion(0, n, row, lie, pie, na);
        return result;
    }

    void recursion(int current, int n, int[] row, int lie, int pie, int na) {
        if (current == n) {
            List<String> tempResult = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(row[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tempResult.add(sb.toString());
            }
            this.result.add(tempResult);
        }

        for (int i = 0; i < n; i++) {
            if ((lie & (1 << i)) == 0 
            && (pie & (1 << (i + current))) == 0 
            && (na & ( 1 << (current + n - 1 - i))) == 0) {
                row[current] = i;
                recursion(current + 1, n, row, lie + (1 << i), pie + (1 << (i + current)), na + (1 << (current + n - 1 - i)));
                row[current] = 0;
            }
        }

    }
}
