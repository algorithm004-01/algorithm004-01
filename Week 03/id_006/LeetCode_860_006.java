package com.mrglint.leetcode.week03.solution860;

/**
 * @author luhuancheng
 * @since 2019-11-03 21:55
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (i == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else {
                    if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

