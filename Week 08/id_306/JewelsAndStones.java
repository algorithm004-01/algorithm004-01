package sf.week8;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LynnSun on 2019/12/7.
 * 力扣题目地址：https://leetcode-cn.com/problems/jewels-and-stones
 */
public class JewelsAndStones {
    // 最好的解法
    public int numJewelsInStones(String J, String S) {
        char[] Jc = J.toCharArray();
        char[] Sc = S.toCharArray();
        int result = 0;
        int[] indexMap = new int[150];
        for (int h = 0;h<S.length();h++)
        {
            indexMap[Sc[h]] = indexMap[Sc[h]]+1;
        }
        for (int i = 0;i<J.length();i++)
        {
            char a = Jc[i];
            result=result+indexMap[a];
        }
        return result;
    }

    /**
     * 官方hash解法
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStonesHash(String J, String S) {
        Set<Character> Jset = new HashSet();
        for (char j: J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s: S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
    }
}
