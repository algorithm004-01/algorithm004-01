/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-07 08:06
 **/

public class Leetcode_917_371 {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";//"Qedo1ct-eeLg=ntse-T!"
        String s1 = reverseOnlyLetters(s);
        System.out.println("s1 = " + s1);

    }

    public static String reverseOnlyLetters(String S) {
        //0.临界判断
        int len = S.length();
        if (len <= 1) return S;
        char[] c = S.toCharArray();
        //1.定义双指针,分别指向字符串首尾
        int i = 0, j = len - 1;
        //2.移动2个指针
        while (i < j) {
            //2.1两个指针都指向字母时,将两个字母交换,i+1,j-1
            if (isAlpha(c[i]) && (isAlpha(c[j]))) {
                char temp = c[i];
                c[i++] = c[j];
                c[j--] = temp;
            } else if (isAlpha(c[i])) {
                //2.2 i 指向字母,j 指向非字母,i 不变,j-1
                j--;
            } else if (isAlpha(c[j])) {
                //2.3 i 指向非字母,j 指向字母,i+1,j 不变
                i++;
            } else {
                //2.4 i,j 都指向非字母,i+1,j-1
                i++;
                j--;
            }
        }
        return new String(c);
    }

    private static boolean isAlpha(char c) {
        return (65 <= c && c <= 90) || (97 <= c && c <= 122);
    }
}
