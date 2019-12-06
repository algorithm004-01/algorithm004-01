package id_031;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
 *
 * 输入: s = "rat", t = "car" 输出: false 说明: 你可以假设字符串只包含小写字母。
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-anagram 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xuhaojie created on 2019-10-22
 */
public class LeetCode_242_031 {

  // 1. 暴力法 将两个字符串排序并判断是否相等 O(nLogn)
  // 2. 使用哈希表统计，并比较
  //    优化：第一个数进入时递增计数，第二个进入时递减计数

  /**
   * 暴力法，将每个字符串字母进行排序，比较是否相等
   */
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null) {
      return false;
    }

    if (s.equals(t)) {
      return true;
    }

    char[] sChars = s.toCharArray();
    Arrays.sort(sChars);
    String sortedS = Arrays.toString(sChars);

    char[] tChars = t.toCharArray();
    Arrays.sort(tChars);
    String sortedT = Arrays.toString(tChars);

    return sortedS.equals(sortedT);
  }

  /**
   * 哈希表统计方法
   */
  public boolean isAnagram1(String s, String t) {
    IntStream sChars = s.chars();
    IntStream tChars = t.chars();
    HashMap<Integer, Long> characterCounter = new HashMap<>();

    //循环第一个字符数组
    OfInt sIterator = sChars.iterator();
    while (sIterator.hasNext()) {
      Integer integer = sIterator.next();
      if (characterCounter.containsKey(integer)) {
        characterCounter.put(integer, characterCounter.get(integer) + 1);
      } else {
        characterCounter.put(integer, 1L);
      }
    }

    //循环第二个字符数组
    OfInt tIterator = tChars.iterator();
    while (tIterator.hasNext()) {
      Integer integer = tIterator.next();
      //不包含的情况，说明一定不为异位词
      if (!characterCounter.containsKey(integer)) {
        return false;
      }
      characterCounter.put(integer, characterCounter.get(integer) - 1);
    }

    boolean equals = true;
    for (Map.Entry<Integer, Long> entry : characterCounter.entrySet()) {
      if (entry.getValue() != 0) {
        equals = false;
      }
    }

    return equals;


  }

  /**
   * 哈希表法，适应 leetcode
   */
  public boolean isAnagram2(String s, String t) {
    HashMap<Character, Integer> characterCounter = new HashMap<>();
    //循环第一个字符数组
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      if (characterCounter.containsKey(sChar)) {
        characterCounter.put(sChar, characterCounter.get(sChar)+ 1);
      } else {
        characterCounter.put(sChar, 1);
      }
    }

    for (int i = 0; i < t.length(); i++) {
      char tChar = t.charAt(i);
      if (!characterCounter.containsKey(tChar)) {
        return false;
      } else {
        characterCounter.put(tChar, characterCounter.get(tChar) - 1);
      }
    }

    boolean equals = true;
    for (Map.Entry<Character, Integer> entry : characterCounter.entrySet()) {
      if (entry.getValue() != 0) {
        equals = false;
      }
    }

    return equals;


  }

  /**
   * 优化，使用数组即可，不需要map存key
   */
  public boolean isAnagram3(String s, String t) {

    if (s == null || t == null) {
      return false;
    }

    if (s.equals(t)) {
      return true;
    }

    if (s.length() != t.length()) {
      return false;
    }

    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }

    for (int j = 0; j < counter.length; j++) {
      if (counter[j] != 0) {
        return false;
      }
    }

    return true;

  }




  public static void main(String[] args) {

    System.out.println(new LeetCode_242_031().isAnagram("anagram", "nagaram"));
    System.out.println(new LeetCode_242_031().isAnagram1("anagram", "nagaram"));
    System.out.println(new LeetCode_242_031().isAnagram2("anagram", "nagaram"));
    System.out.println(new LeetCode_242_031().isAnagram3("anagram", "nagaram"));

  }


}
