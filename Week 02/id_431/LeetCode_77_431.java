package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/25
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        _reserval(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    private void _reserval(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n + 1; i++){
            list.add(i);
            _reserval(result, list, i + 1, n, k-1);
            list.remove(list.size() - 1);
        }
    }
}
