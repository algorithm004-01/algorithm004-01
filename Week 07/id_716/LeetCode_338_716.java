
public class LeetCode_338_716 {
    // 1. loop every item
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countBitsOfANumber(i);
        }
        return res;
    }

    private int countBitsOfANumber(int i) {
        int cnt = 0;
        while (i != 0) {
            i = i & (i - 1);
            cnt++;
        }
        return cnt;
    }

    // 2. dp
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    // 3. dp
    public int[] countBits3(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}