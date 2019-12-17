/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-05 09:08
 **/

public class Leetcode_771_371 {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        int cnt = numJewelsInStones(J, S);
        System.out.println("cnt = " + cnt);
    }

    public static int numJewelsInStones(String J, String S) {
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if(J.contains(String.valueOf(S.charAt(i)))) cnt++;
        }
        return cnt;
    }
}
