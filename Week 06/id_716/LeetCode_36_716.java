import java.util.HashMap;
import java.util.Map;

public class LeetCode_36_716 {
    
    // 1. HashMap
    public boolean isValidSudoku1(char[][] board) {
        @SuppressWarnings("unchecked") Map<Integer, Integer>[] rows = new HashMap[9];
        @SuppressWarnings("unchecked") Map<Integer, Integer>[] cols = new HashMap[9];
        @SuppressWarnings("unchecked") Map<Integer, Integer>[] boxed = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxed[i] = new HashMap<>();
        }

        // search the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int numN = (int) num;
                    int boxIdx = (i / 3) * 3 + j / 3;

                    rows[i].put(numN, rows[i].getOrDefault(numN, 0) + 1);
                    cols[j].put(numN, cols[j].getOrDefault(numN, 0) + 1);
                    boxed[boxIdx].put(numN, boxed[boxIdx].getOrDefault(numN, 0) + 1);

                    if (rows[i].get(numN) > 1 || cols[j].get(numN) > 1 || boxed[boxIdx].get(numN) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    // 2. Bit
    public boolean isValidSudoku2(char[][] board) {

        for (int i = 0; i < 9; i++) {
            int row = 0, col = 0, sqre = 0;
            for (int j = 0; j < 9; j++) {
                int r = board[i][j] - 48,
                        c = board[j][i] - 48,
                        s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;

                if (r > 0) row = sodokuer(r, row);
                if (c > 0) col = sodokuer(c, col);
                if (s > 0) sqre = sodokuer(s, sqre);
                if (row == -1 || col == -1 || sqre == -1) return false;
            }
        }
        return true;
    }

    private int sodokuer(int n, int val) {
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
    }

    // 3
    public boolean isValidSudoku3(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int value = (1 << (board[i][j] - '1'));
                    int index = (i / 3) * 3 + j / 3;
                    if ((value & row[i]) > 0 || (value & col[j]) > 0 || (value & box[index]) > 0) {
                        return false;
                    }
                    row[i] |= value;
                    col[j] |= value;
                    box[index] |= value;
                }
            }
        }
        return true;
    }
}