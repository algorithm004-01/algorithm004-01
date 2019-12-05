package id_031;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author xuhaojie created on 2019-10-27
 */
public class LeetCode_94_031 {


  public List<Integer> inorderTraversal(TreeNode root) {
    //terminator
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    //process
    //left
    //recursion
    result.addAll(inorderTraversal(root.left));
    result.add(root.val);
    //right
    //recursion
    result.addAll(inorderTraversal(root.right));

    //revert/restore state

    return result;

  }

}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
