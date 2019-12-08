package Week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_77 {
    private List<List<Integer>> list = new LinkedList<>();
    private List<Integer> lis = new LinkedList<>();

    public static void main(String[] args) {
        int n = 4, k = 2;
        Leetcode_77 ss = new Leetcode_77();
        List<List<Integer>> lists = ss.combine3(n,k);
        for (List<Integer> li : lists ) {
            System.out.println(Arrays.toString(li.toArray()));
        }
    }

    /**
     * 英文站高票写法
     * 执行用时 :49 ms, 在所有 java 提交中击败了40.73%的用户
     * 内存消耗 :46.1 MB, 在所有 java 提交中击败了82.82%的用户
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> combine3(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }

    /**
     * 沙雕递归
     * 执行用时 :41 ms, 在所有 java 提交中击败了44.84%的用户
     * 内存消耗 :41.1 MB, 在所有 java 提交中击败了87.05%的用户
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> combine(int n, int k) {
        help(1,0, n, k);
        return this.list;
    }

    private void help(int index, int count, int n, int k) {
        if (count == k) {

            this.list.add(new LinkedList<>(lis));
            return;
        }
        for (int i = index; i <= n ; i++) {
            this.lis.add(0,i);
            help(i + 1, count + 1, n, k);
            this.lis.remove(0);
        }
    }

    /**
     * 题解回溯法
     * 执行用时 :15 ms, 在所有 java 提交中击败了72.79%的用户
     * 内存消耗 :43.1 MB, 在所有 java 提交中击败了84.49%的用户
     * 为什么比我快那么多。。。。。。。。。
     * @param n
     * @param k
     * @return
     */

    int n;
    int k;

    private List<List<Integer>> combine1(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return list;
    }

    private void backtrack(int index, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            list.add(new LinkedList<>(curr));
        }

        for (int i = index; i <= n ; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    /**
     * 题解字典法
     * 没看懂。。。。
     * 执行用时 :11 ms, 在所有 java 提交中击败了76.27%的用户
     * 内存消耗 :43.5 MB, 在所有 java 提交中击败了83.46%的用户
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> combine2(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new LinkedList<>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;

    }


}
