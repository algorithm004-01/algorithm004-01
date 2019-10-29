import java.util.*;
/**
 * 括号生成
 */
public class Solution {
    /**
     * 括号生成
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        _generateParenthesis(n, 0, 0, list, "");
        return list;
    }

    private void _generateParenthesis(int max, int leftSum, int rightSum, List<String> res, String s) {
        if (leftSum + rightSum == 2 * max) {
            res.add(s);
            return;
        }
        if (leftSum < max) {
            _generateParenthesis(max, leftSum + 1, rightSum, res, s + "(");
        }
        if (rightSum < leftSum) {
            _generateParenthesis(max, leftSum, rightSum + 1, res, s + ")");
        }
    }
}