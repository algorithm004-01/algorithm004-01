package sf.week8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LynnSun on 2019/12/8.
 * 力扣题目地址：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagramsInAString {
    /**
     * 双指针
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p){
        int[] count = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0, right = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            int idx = s.charAt(right++) - 'a';
            window[idx]++;
            while (count[idx] < window[idx]) {
                window[s.charAt(left++) - 'a']--;
            }
            if (right - left == p.length()) {
                list.add(left);
            }
        }
        return list;
    }

    /**
     * 依次判断法&类KMP算法
     * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/java-liang-fang-fa-yi-ci-pan-duan-fa-lei-kmpsuan-f/
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        int conter = 0;
        StringBuilder sb = new StringBuilder(p);

        List<Integer> result = new ArrayList();

        for(int i=0; i<slength; i++)
        {
            if(sb.indexOf(Character.toString(s.charAt(i))) != -1)
            {
                conter++;
                sb.delete(sb.indexOf(Character.toString(s.charAt(i))), sb.indexOf(Character.toString(s.charAt(i)))+1);
            }
            else
            {
                if(p.indexOf(Character.toString(s.charAt(i))) != -1)
                {
                    conter--;
                    i--;
                    sb.append(s.charAt(i-conter));
                }
                else
                {
                    conter = 0;
                    sb =  new StringBuilder(p);
                }
            }


            if(conter == plength)
            {
                result.add(i-plength+1);
                conter--;
                sb.append(s.charAt(i-plength+1));
            }
        }
        return result;


    }
}
