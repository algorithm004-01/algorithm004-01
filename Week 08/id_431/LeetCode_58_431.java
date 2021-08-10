package easy;

import java.util.Deque;

/**
 * @author 潘磊明
 * @date 2019/12/11
 */
public class LengthOfLastWord {
//    public int lengthOfLastWord(String s) {
//        int length = 0;
//        int tmp = 0;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == ' ') {
//                if (tmp != 0) length = tmp;
//                tmp = 0;
//            }
//            else tmp += 1;
//        }
//        return tmp == 0 ? length : tmp;
//    }

    public int lengthOfLastWord(String s) {
        String[] tmp = s.trim().split(" ");
        return tmp[tmp.length - 1].length();
    }
}
