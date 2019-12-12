using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 236. 二叉树的最近公共祖先
    /// </summary>
    public class LowestCommonAncestorOfABinaryTree
    {
      
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if (root == null || root == p || root == q) return root;
            TreeNode left = LowestCommonAncestor(root.left, p, q);
            TreeNode right = LowestCommonAncestor(root.right, p, q);

            return left == null ? right : (right == null ? left : root);


        }
    }
}
