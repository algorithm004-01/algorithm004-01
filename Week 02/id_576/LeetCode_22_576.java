import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_22_576
 */
public class LeetCode_22_576 {

    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        _generate(0, 0, n, "");
        return result;
    }

    public void _generate(int left, int right, int n, String s) {
        //terminator
        if (left ==n && right == n) {
            result.add(s);
            return;
        }
        // process current logic: left, right
        
        //drill down
        if (left < n) _generate(left + 1, right, n, s + "(");
        if (left > right) _generate(left ,right + 1, n, s + ")");

        // reverse states

    }

    public static void main(String[] args) {
        LeetCode_22_576 l22 = new LeetCode_22_576();
        System.out.println(l22.generateParenthesis(3));
    }
}