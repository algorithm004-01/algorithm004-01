import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-05 11:31
 **/

public class Leetcode_387_371 {
    public static void main(String[] args) {
//        String s = "leetcode";
//        String s = "llttnn";
        String s = "loveleetcode";
        int i = firstUniqChar2(s);
        System.out.println("i = " + i);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //1.一次遍历,放入 map(0,l)
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //2.存在删除
            if(map.containsKey(ch)) map.put(ch, i + 1);
            else map.put(s.charAt(i), i);

        }
        //3.按顺序取,取到就返回
        for (int i = 0; i < s.length(); i++) {
            Integer integer = map.get(s.charAt(i));
            if (integer == i) return i;
        }
        return -1;
    }

    /**
     * 防解:
     * @author Shaobo.Qian
     * @date 2019/12/6
     * @link https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-fu-by-leet/
     */
    public static int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //1.一次遍历,放入 map(0,l)
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //2.存在删除
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //3.按顺序取,取到就返回
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    /**
     * 防解2:字符转数组
     * @author Shaobo.Qian
     * @date 2019/12/6
     */
    public static int firstUniqChar2(String s) {
        int[] letter = new int[26];
        for (char ch : s.toCharArray()) {
            letter[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letter[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }
}
