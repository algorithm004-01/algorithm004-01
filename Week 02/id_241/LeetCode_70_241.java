import java.util.*;
/**
 * 爬楼梯
 */
public class Solution {
    public int climbStairs(int n) {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        if (n <= 2) return n;
        for (int i = 3; i < n + 1; i++) {
            n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}