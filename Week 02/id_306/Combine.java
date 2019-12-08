import java.util.ArrayList;
import java.util.List;

/**
 * Created by LynnSun on 2019/10/27.
 */
public class Combine {
    private ArrayList<List<Integer>> res;
    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素

    /**
     * 回溯+剪枝
     * @param n
     * @param k
     * @param start
     * @param list
     */
    private void generateCombinations(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //减枝  i <= n-(k-list.size())+1
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            generateCombinations(n, k, i + 1, list);
            list.remove(list.size() - 1);

        }
    }

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        generateCombinations(n, k, 1, list);

        return res;

    }
}
