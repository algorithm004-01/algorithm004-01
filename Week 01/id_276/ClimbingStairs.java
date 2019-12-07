public class ClimbingStairs {
    /*public int climbingStairs(int n) {
        // fibonicicc 时间复杂副：O(2^n)
        if (n <= 2) {
            return n;
        } else {
            return climbStair(n-1)+climbStairs(n-2);
        }
    }*/

    /*public int climbingStairs(int n) {
        //用数组保存每一个n的方法次数
        int[] ways = new int[n];
        if (n <= 2) {
            return n;
        }
        ways[0] = 1;
        ways[1] = 2;

        for (int i=3;i<n;++i) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n-1];
    }*/

    public int climbingStair(int n) /*{

        if (n <= 2) {
            return n;
        }
        int first,second;
        first = 1;
        second = 2;

        for (int i=3;i<=n;++i) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }*/
}
