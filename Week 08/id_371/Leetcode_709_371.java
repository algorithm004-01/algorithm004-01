/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-05 07:43
 **/

public class Leetcode_709_371 {
    public static void main(String[] args) {
        String res = toLowerCase1("ABbD");
        System.out.println("res.toString() = " + res);

    }

    public static String toLowerCase(String str) {

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if(ch >=65 && ch <=90) chars[i] = (char) (ch + 32);
        }

        return String.valueOf(chars);
    }

    public static String toLowerCase1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) (str.charAt(i) | 32));
        }
        return sb.toString();
    }

}
