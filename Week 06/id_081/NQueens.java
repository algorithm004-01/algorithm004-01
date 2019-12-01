public class NQueens {
    int n;
    Set<Integer> cols;
    Set<Integer> pies;
    Set<Integer> nas;
    List<List<String>> res;

    LinkedList<Integer> queue;

    /**
     * 在的思路是剪枝
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return new ArrayList<>();

        this.n = n;
        nas = new HashSet<>();
        cols = new HashSet<>();
        pies = new HashSet<>();
        queue = new LinkedList<>();
        res = new ArrayList<>();
        _solveNQueue(0);
        return res;
    }

    public void _solveNQueue(int row) {
        if (row >= n) {
            res.add(generateList(new LinkedList<>(queue), n));
            return;
        }

        for (int col = 0; col < n; ++col) {
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col))
                continue;
            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);
            queue.addLast(col);

            _solveNQueue(row + 1);

            queue.removeLast();
            cols.remove(col);
            pies.remove(row + col);
            nas.remove(row - col);
        }
    }

    public List<String> generateList(Queue<Integer> queue, int n) {
        List<String> board = new ArrayList<>();
        for (Integer integer : queue) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i)
                sb.append(".");
            sb.replace(integer, integer + 1, "Q");
            board.add(sb.toString());
        }
        return board;
    }
}