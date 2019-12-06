import java.util.*;
/**
 * 组合
 */
public class Solution {
    /**
     * 组合
     */
    private int num;
    private int size;
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        num = n;
        size = k;
        result = new ArrayList<>();
        combineHelper(1, new LinkedList<>());
        return result;
    }

    private void combineHelper(int begin, LinkedList<Integer> curr) {
        if (curr.size() == size) {
            result.add(new LinkedList<>(curr));
            //TODO()不加 return，运行时间从 48ms 缩短到 14ms?
            //return;
        }
        for (int i = begin; i < num + 1; i++) {
            curr.add(i);
            combineHelper(i + 1, curr);
            curr.removeLast();
        }
    }
}