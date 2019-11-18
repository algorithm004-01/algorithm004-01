/**
 * Fibonacci
 */
public class Fibonacci {

    int fib1 (int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else{
            return fib(n - 1) + fib(n - 2);
        }
    }

    //更简洁的写法
    int fib2 (int n) {
        return n <= 1 ? n : fib1(n - 1) + fib1(n - 2);
    }

    //时间复杂度上的优化，添加一个缓存,o(n)， 记忆化搜索
    int fib3 (int n, int[] memo) {
        //terminator
        if (n <= 1) {
            return n;
        } 
        if (memo[n] == 0) {
            memo[n] = fib2(n - 1) + fib2(n - 2);
        }
        return memo[n];
    }

    //bottom up，终极模版
    int fib4 (int n) {
        if (n <= 1) return n;
        int[] a = new int[n];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}