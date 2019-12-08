using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 105. 从前序与中序遍历序列构造二叉树
    /// </summary>
    public class ConstructBinaryTreeFromPreorderAndInorderTraversal
    {
       
        /// <summary>
        /// 方法一：递归
        /// </summary>
        /// <param name="preorder"></param>
        /// <param name="inorder"></param>
        /// <returns></returns>
        public TreeNode BuildTree(int[] preorder, int[] inorder)
        {
            return Helper(0, 0, inorder.Length - 1, preorder, inorder);
        }

        public TreeNode Helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder)
        {
            if (preStart > preorder.Length - 1 || inStart > inEnd)
            {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inIndex = 0; 
            for (int i = inStart; i <= inEnd; i++)
            {
                if (inorder[i] == root.val)
                {
                    inIndex = i;
                }
            }
            root.left = Helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
            root.right = Helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
            return root;
        }


    }
}
