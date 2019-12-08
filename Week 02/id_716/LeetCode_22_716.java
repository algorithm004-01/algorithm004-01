import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/generate-parentheses
// 括号生成

public class LeetCode_22_716 {
    // 1. 递归解法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        _generate(0, 0, n, "", res);
        return res;
    }
    
    // 一定是先放左括号，再放右括号，不然不合法
    // 左括号的个数 == 右括号的个数 == n
    // 在添加括号的过程中：左括号个数 >= 右括号个数，只有当左括号个数大于右括号个数时才可以添加右括号
    // 只有当左括号个数小于n时才可以添加左括号
    // left: 表示添加的左括号个数；right: 表示添加的右括号个数
    // s: 表示已经生成的字符串
    private void _generate(int left, int right, int n, String s, List<String> res) {
        // terminator：左右括号个数都等于n时，生成完毕
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        // process current logic: add left or add right
        
        // drill down
        if (left < n) {
            _generate(left + 1, right, n, s + "(", res);
        }
        
        if (left > right) {
            _generate(left, right + 1, n, s + ")", res);
        }
        
        // revert status
    }
}