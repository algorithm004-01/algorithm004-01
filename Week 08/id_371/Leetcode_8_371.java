/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-06 07:30
 **/

public class Leetcode_8_371 {
    public static void main(String[] args) {
//        String str = "words and 987";
//        String str = "-41933430000 with words";
//        String str = "0000 with words";
//        String str = "20000000000000000000";
//        String str = "   -42";
//        String str = "   42";
        String str = "-000000000000001";

//        String str = "+1";
        int i = myAtoi(str);
        System.out.println("i = " + i);
    }

    /**
     * 原解
     * @author Shaobo.Qian
     * @date 2019/12/6
     */
    public static int myAtoi(String str) {

        //1.处理空格
        str = str.trim();
        if (str.length() == 0) return 0;
        String first = String.valueOf(str.charAt(0));
        if (!"+-0123456789".contains(first)) return 0;
        boolean isPositive = false;
        StringBuilder sb = new StringBuilder();
        //2.处理正负
        //去掉零
        boolean zeroflag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if (c == '+') {
                    isPositive = true;
                    continue;
                } else if (c <= '9' && c >= '0') {
                    isPositive = true;
                    if (c == '0') {
                        continue;
                    }
                    zeroflag = true;
                } else if (c == '-') {
//                    zeroflag = true;
                    continue;
                }
            }
            if (zeroflag) {
                if (c <= '9' && c >= '0') {
                    sb.append(c);
                } else {
                    break;
                }
            } else {
                if (c != '0') {
                    if (c <= '9' && c >= '0') {
                        sb.append(c);
                        zeroflag = true;
                    } else {
                        break;
                    }
                }
            }
        }

        //3.转换成数字
        String res = sb.toString();

//        Integer res;
        if (res.length() == 0) return 0;
        Integer result;
        if (isPositive) {
            if (res.length() > 10) {
                result = Integer.MAX_VALUE;
            } else {

                result = Math.toIntExact(Math.min(Long.parseLong(res), Integer.MAX_VALUE));
            }
        } else {
            if (res.length() > 10) {
                result = Integer.MIN_VALUE;
            } else {
                result = Math.toIntExact(Math.max(0 - Long.parseLong(res), Integer.MIN_VALUE));
            }
        }
        //4.处理溢出

        return result;
    }

    /**
     * 重构优化:使用 continue,break代替标记
     * @author Shaobo.Qian
     * @date 2019/12/6
     */
    public static int myAtoi1(String str) {
        return 0;
    }

}
