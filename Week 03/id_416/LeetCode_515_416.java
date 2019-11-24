/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_416{
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if(null == root) return list;
        deque.offer(root);
        while(!deque.isEmpty()) {
            int len = deque.size();
            int max = Integer.MIN_VALUE;
            while(len-- > 0){
                TreeNode treeNode = deque.pop();
                int cur = treeNode.val;
                if(cur > max)  max = cur;
                if(null != treeNode.left)  deque.offer(treeNode.left);
                if(null != treeNode.right) deque.offer(treeNode.right);
            }
            list.add(max);
        }
        return list;
    }
}