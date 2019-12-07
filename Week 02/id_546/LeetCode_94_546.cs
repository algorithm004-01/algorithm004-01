using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 94. 二叉树的中序遍历
    /// </summary>
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public class BinaryTreeInorderTraversal
    {
        /// <summary>
        /// 方法一：递归法
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public IList<int> InorderTraversal1(TreeNode root)
        {
            List<int> res = new List<int>();
            Helper(root, res);
            return res;
        }
        public void Helper(TreeNode root, List<int> res)
        {
            if (root == null) return;
            Helper(root.left, res);
            res.Add(root.val);
            Helper(root.right, res);
        }

        /// <summary>
        /// 方法二：遍历法
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public IList<int> InorderTraversal2(TreeNode root)
        {
            List<int> res = new List<int>();

            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;
            while (curr != null || stack.Any())
            {
                while (curr != null)
                {
                    stack.Push(curr);
                    curr = curr.left;
                }
                curr = stack.Pop();

                res.Add(curr.val);

                curr = curr.right;
            }
            return res;

        }
    }
}
