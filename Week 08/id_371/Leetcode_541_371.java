/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-06 08:59
 **/

public class Leetcode_541_371 {
    public static void main(String[] args) {
        String s = "abcdefgttabcdb";
        int k = 3;
        //"bacdfeg"
        String res = reverseStr1(s, k);
        System.out.println("res = " + res);
    }

    /**
     * 原解1
     *
     * @author Shaobo.Qian
     * @date 2019/12/6
     */
    public static String reverseStr(String s, int k) {

        //1.以 k 分段,
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        int len = s.length();
        boolean oddFlag = true;
        while (begin + k <= len) {
            // 2.获取奇数端翻转,
            if (oddFlag) {
                StringBuilder kSb = new StringBuilder();
                sb.append(kSb.append(s, begin, begin + k).reverse().toString());
                oddFlag = false;
            } else {
                // 3.获取偶数段不变
                oddFlag = true;
                sb.append(s, begin, begin + k);
            }
            begin += k;
        }

        //4.append the remaining
        if (oddFlag) {
            for (int i = len - 1; i >= begin; i--) {
                sb.append(s.charAt(i));
            }
        } else {
            sb.append(s, begin, len);
        }
        return sb.toString();
    }


    /**
     * 防解
     * @author Shaobo.Qian
     * @date 2019/12/7
     * @link https://leetcode-cn.com/problems/reverse-string-ii/solution/fan-zhuan-zi-fu-chuan-ii-by-leetcode/
     */
    public static String reverseStr1(String s, int k) {
        char[] a = s.toCharArray();
        for (int begin = 0; begin < s.length(); begin += 2 * k) {
            int i = begin, j = Math.min(begin + k - 1, s.length() - 1);
            while (i < j) {
                char temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }

        }
        return new String(a);

    }

}
