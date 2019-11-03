using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Medium
{
    /// <summary>
    /// 144. 二叉树的前序遍历
    /// </summary>
    public class BinaryTreePreorderTraversal
    {
        /// <summary>
        /// 方法一：递归法
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public IList<int> PreorderTraversal(TreeNode root)
        {
            List<int> res = new List<int>();

            Helper(root, res);
            return res;

        }

        public void Helper(TreeNode root,List<int> res){

            if (root == null) return;
            res.Add(root.val);
            Helper(root.left,res);
            Helper(root.right,res);

        }



        /// <summary>
        /// 方法二：迭代法
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public List<int> PreorderTraversal2(TreeNode root)
        {
            List<int> list = new List<int>();
            Stack<TreeNode> rights = new Stack<TreeNode>();

            while (root != null)
            {
                list.Add(root.val);
                if (root.right != null)
                {
                    rights.Push(root.right);
                }
                root = root.left;
                if (root == null && rights.Any())
                {
                    root = rights.Pop();
                }
            }
            return list;
        }

    }
}
