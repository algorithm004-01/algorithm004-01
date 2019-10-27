//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树

package leetcode.editor.cn;

import java.lang.reflect.Array;

//Java：二叉树的最近公共祖先
public class LeetCode_236_541{
    public static void main(String[] args) {
        Solution solution = new LeetCode_236_541().new Solution();
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
   // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TreeNode
         // n = 1 ,3 , left = n+1 = 5,right = n+2 = 1 .
         // n = 2, 5 , left = n+2 = 6 ,right = n+3 = 2 .
         // n = 3, 1 , left = n+3 = 0 ,right = n+4 = 8 .
         //
         // n = n ,2n,2n+1

        //解法1：1.root 先序遍历->数组，2.在数组里面找最近p,q,然后逆向求解出其根节点，将根节点存放在list里面，找最近公共节点
            //优化：可以用栈来替代1步骤。

        //解法2：递归+回溯

        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left == null) return right;
        if (right == null) return left;
        return root;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}