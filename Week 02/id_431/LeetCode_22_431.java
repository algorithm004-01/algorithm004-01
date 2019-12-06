package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/10/23
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        _generate(0, 0, n, "", list);
        return list;
    }

    private void _generate(int left, int right, int n, String s, List<String> list){
        if (left == n && right == n) {
            list.add(s);
        }
        if (left < n)
                _generate(left + 1, right, n, s + "(", list);
        if (right < left && right < n)
                _generate(left, right + 1, n, s + ")", list);
    }
}
