/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_102_416{

    /**
     * 深度优先搜索（通过level巧妙的获取了数组中的层序）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(null == root) return list;
        helper(0,root,list);
        return list;
    }
    public void helper(int level , TreeNode node , List<List<Integer>> list) {
        if(level == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(node.val);
        if(null != node.left)  helper(level + 1 ,node.left,list);
        if(null != node.right) helper(level + 1 ,node.right,list);
    }

    /**
     * 广度优先搜索（手动维护一个双端队列，每次遍历把上一层的阶段遍历完pop，把下一层节点放入进去offer
     * 注意点：int size = queue.size()需要用一个变量接受）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(null == root) return  ret;
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> lis = new ArrayList<Integer>();
            int size = queue.size();
            for(int i =0;i<size;i++) {
                TreeNode currNode = queue.pop();
                lis.add(currNode.val);
                if(null != currNode.left) queue.offer(currNode.left);
                if(null != currNode.right) queue.offer(currNode.right);
            }
            ret.add(lis);
        }
        return ret;
    }

}
