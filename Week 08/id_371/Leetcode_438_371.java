import java.util.*;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-07 09:41
 **/

public class Leetcode_438_371 {
    public static void main(String[] args) {
//        String s = "cbaebabacd", p = "abc";
        String s = "abab", p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        anagrams.stream().forEach(System.out::println);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        //0.处理边界
        int sLen = s.length();
        int pLen = p.length();
        //1.定义数组记录异位词的索引位置
        List<Integer> indexs = new ArrayList<>();
        if (pLen > sLen) return indexs;
        //2.以 p 的长度为单位从左到右滑动
        char[] pChar = p.toCharArray();
        char[] sChar = s.substring(0, pLen).toCharArray();
        for (int i = pLen; i < sLen; i++) {
            char newChar = s.charAt(pLen);
            //3.判断是否是异位词
            if (isAnagrams(sChar, pChar, newChar)) {
                indexs.add(i);
            }
        }
        return indexs;
    }

    /**
     * 记录每个字符出现的次数
     *
     * @author Shaobo.Qian
     * @date 2019/12/7
     */
    private static boolean isAnagrams(char[] sChar, char[] pChar,char newChar) {
        //0.先判断 hash 值是否一样
        if(!sameHash(sChar,pChar,newChar)) return false;
        //1.创建map
        Map<Character, Integer> map = new HashMap<>();
        //2.记录 s 中的字符个数
        for (char sCh : sChar) {
            map.put(sCh, map.getOrDefault(sCh, 0) + 1);
        }
        //3.在 p 中比较
        for (char pCh : pChar) {
            if (!map.containsKey(pCh) || map.get(pCh) < 1) return false;
            map.put(pCh, map.get(pCh) - 1);
        }
        return true;
    }

    private static boolean sameHash(char[] sChar, char[] pChar, char newChar) {
        sChar[0] = newChar;
        return false;
    }


}
