/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_416{
    /**
     * DFS：深度优先搜索
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        _generate("",0,0,2 * n,list);
        return list;
    }
    public void _generate(String item,int left,int right,int max,List<String> list){
        if(left == max/2 && right == max/2 ) {//terminator
            list.add(item);
            return;
        }
        if(left < max/2) {//左括号要小于n，那么我们还可以用一个括号
            //drill down
            _generate(item+"(",left+1,right,max,list);
        }
        if(right < left) {//右括号要小于左括号
            //drill down
            _generate(item+")",left,right + 1,max,list);
        }
        //restore states
    }
}