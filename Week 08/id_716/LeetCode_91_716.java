public class LeetCode_91_716 {
    // 1. dp，可读性好
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            // 走一步合法
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            // 走两步合法
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
            // 否则，什么也不做
        }
        return dp[n];
    }

    // 2. dp，可读性差
    public int numDecodings2(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') return 0;
        int[] nums = new int[len];
        nums[0] = 1;
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            char pre = s.charAt(i - 1);
            nums[i] = nums[i - 1];
            if (ch == '0' && (pre > '2' || pre == '0')) return 0;
            if (ch > '2' && i < len - 1 && s.charAt(i + 1) == '0') return 0;

            if (pre > '0' && ch > '0' && (i == len - 1 || s.charAt(i + 1) != '0')) {
                int v = ch - '0' + (pre - '0') * 10;
                if (v < 27) {
                    if (i > 2) {
                        nums[i] += nums[i - 2];
                    } else {
                        nums[i] += 1;
                    }
                }
            }
        }
        return nums[len - 1];
    }


    // 3. dp
    // 此问题可以理解为爬楼梯问题，但是增加了很多限制
    // 到第i个位置的解码数可以由两种途径获得：到i-1个位置增加1个数 + 到i-2个位置增加两个数
    public int numDecodings3(String s) {
        if (s.startsWith("0")) {
            return 0;
        }

        int n = s.length();
        // dp[i] 表示到第 i 个位置能解码方法的总数
        int[] dp = new int[n + 1];
        // init base case
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 如果该位置为0，且和前一个位置组合出来不再 1~26 中，说明无解
            //  e.g.: 00 30 40 50 60 70 80 90
            if (isZero(s.charAt(i - 1)) && !valid(s.substring(i - 2, i))) {
                return 0;
            }
            // 如果该位置为0，且和前一个位置组合出来合法，e.g.: 10 20, 说明只能增加两位数(走两步)
            //  dp[i] 只能等于 dp[i-2]
            if (isZero(s.charAt(i - 1))) {
                dp[i] = dp[i - 2];
            } else {
                // 如果前一个位置为0 或者 当前位置和前一个位置组合出来不再 1～26 中，说明只能走一步
                //  dp[i] 只能等于 dp[i-1]
                if (isZero(s.charAt(i - 2)) || !valid(s.substring(i - 2, i))) {
                    dp[i] = dp[i - 1];
                } else {
                    // 这种情况就属于正常的可以走1步和两步
                    //   e.g.: 23 -> 在i-1的情况下添加3
                    //            -> 在i-2的情况下添加23
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }

        return dp[n];
    }

    private boolean valid(String str) {
        if (str.startsWith("0")) return false;
        int i = Integer.parseInt(str);
        return 1 <= i && i <= 26;
    }

    private boolean isZero(char c) {
        return c - '0' == 0;
    }

    // 4. dp, 节省内存
    public int numDecodings4(String s) {
        if (s.startsWith("0")) {
            return 0;
        }

        int n = s.length();

        // init base case
        int prev2 = 1;
        int prev1 = 1;
        int num = 1;

        for (int i = 2; i <= n; i++) {
            // 如果该位置为0，且和前一个位置组合出来不再 1~26 中，说明无解
            //  e.g.: 00 30 40 50 60 70 80 90
            if (isZero(s.charAt(i - 1)) && !valid(s.substring(i - 2, i))) {
                return 0;
            }
            // 如果该位置为0，且和前一个位置组合出来合法，e.g.: 10 20, 说明只能增加两位数(走两步)
            //  dp[i] 只能等于 dp[i-2]
            if (isZero(s.charAt(i - 1))) {
                num = prev2;
                // dp[i] = dp[i - 2];
                prev2 = prev1;
                prev1 = num;
            } else {
                // 如果前一个位置为0 或者 当前位置和前一个位置组合出来不再 1～26 中，说明只能走一步
                //  dp[i] 只能等于 dp[i-1]
                if (isZero(s.charAt(i - 2)) || !valid(s.substring(i - 2, i))) {
                    // dp[i] = dp[i - 1];
                    num = prev1;
                    prev2 = prev1;
                    prev1 = num;
                } else {
                    // 这种情况就属于正常的可以走1步和两步
                    //   e.g.: 23 -> 在i-1的情况下添加3
                    //            -> 在i-2的情况下添加23
                    // dp[i] = dp[i - 1] + dp[i - 2];
                    num = prev1 + prev2;
                    prev2 = prev1;
                    prev1 = num;
                }
            }
        }

        return num;
    }
}