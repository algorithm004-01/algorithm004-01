package easy;

/**
 * @author 潘磊明
 * @date 2019/12/11
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }
}
