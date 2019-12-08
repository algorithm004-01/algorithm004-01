package LeetCode_36_041;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set set =new HashSet();
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9;j++){
                char number = board[i][j];
                if(number != '.'){
                    if(!set.add(number + "in cow" + i) || !set.add(number+ "in column "+ j)
                            || !set.add(number + "in block "+ i/3 + "-" + j/3)) return false;
                }
            }
        }
        return true;
    }
}