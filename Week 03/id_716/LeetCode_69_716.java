
public class LeetCode_69_716 {

    // 1. 二分搜索
    // 1.1
    public int mySqrt11(int x) {
        if (x == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + ((right - left) >> 1);
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    // 1.2
    public int mySqrt12(int x) {
        // 平方根一定在 1 ~ (x/2 + 1)之间
        if (x == 0) return 0;

        int left = 1, right = (x >> 1);
        while (left < right) {
            int mid = left + ((right - left) >> 1);

            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            }
        }

        return left;
    }

    // 1.3
    public int mySqrt13(int x) {
        int left = 1, right = x, res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid <= x / mid) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return res;
    }

    // 1.4
    public int mySqrt14(int x) {
        if (x == 0 || x == 1) return x;
        
        int left = 1, right = x >> 1;
        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return right <= x / right ? right : left;
    }

    // 2 牛顿法，这个写法确实有些巧妙，收敛速度更快
    // 可以这么理解：从 x 和 1 开始从两端向中间收敛，r 的起始值是 x，x/r 的起始值是 1，随着 r 的减小，x/r 在增大
    // 这两个值都在向 x 的平方根收敛，当到达平方根时 r == x/r, 可以推测，r 是从大到小单调递减的
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        long r = x;
        while (r > x / r) {
            r = (r + x / r) >> 1;
        }
        return (int) r;
    }
}