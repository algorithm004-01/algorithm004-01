class Solution {

    public boolean isValidSudoku(char[][] board) {
    // 国际站学习到的解法：利用了set中没有重复元素这一特性
    Set seen = new HashSet();
    
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
    }
}