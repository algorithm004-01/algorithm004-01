using System.Collections.Generic;
using Poplar.Algorithm.Models;

namespace Poplar.Algorithm.WeekTwo
{
    /// <summary>
    /// 二叉树的最近公共祖先
    /// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    /// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
    /// </summary>
    public class LowestCommonAncestorOfABinaryTreeSol
    {
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if (root == null)
            {
                return null;
            }
            //return FindPOrQ(root, p, q);
            //return Map(root, p, q);
            return Path(root, p, q);
        }

        /// <summary>
        /// 使用字典，字典的key是当前节点，value是当前节点的父节点。
        /// 在对二叉树进行遍历的时候，将当前节点和当前节点父节点装进字典中。
        /// 遍历完二叉树之后，将p和p的所有祖先节点都装进一个hashset中。
        /// 再处理q以及q的祖先节点，只要q或者q的祖先节点中有一个节点在上面的hashset中存在，那么这个节点就是公共祖先。
        /// 时间复杂度是O(n)。N是二叉树中的节点数，最坏情况下，我们需要访问二叉树的所有节点
        /// 空间复杂度是O(n)。因为使用了字典。
        /// </summary>
        /// <param name="root"></param>
        /// <param name="p"></param>
        /// <param name="q"></param>
        /// <returns></returns>
        private TreeNode Map(TreeNode root, TreeNode p, TreeNode q)
        {
            var parent = new Dictionary<TreeNode, TreeNode>() { { root, null } };
            var stack = new Stack<TreeNode>();
            stack.Push(root);
            while (!parent.ContainsKey(p) || !parent.ContainsKey(q))
            {
                var node = stack.Pop();
                if (node.left != null)
                {
                    parent.Add(node.left, node);
                    stack.Push(node.left);
                }
                if (node.right != null)
                {
                    parent.Add(node.right, node);
                    stack.Push(node.right);
                }
            }
            var ancestor = new HashSet<TreeNode>();
            while (p != null)
            {
                ancestor.Add(p);
                p = parent[p];
            }
            while (q != null && !ancestor.Contains(q))
            {
                q = parent[q];
            }
            return q;
        }

        /// <summary>
        /// 第一种方法，找P或者Q。
        /// 在遍历二叉树的时候，针对当前节点的左右子树去查找P或者Q，只要找到P或者Q，就返回，找到的那个节点的所有子树都不会再遍历
        /// 如果只找到其中一个，则证明所有遍历过的节点中不存在另外一个，那么另外一个只能在找到的那个节点的子树中。
        /// 如果找到两个，则证明P和Q在当前节点的左右子树中，那么当前节点就是P和Q的最近公共祖先。
        /// 时间复杂度是O(n)。N是二叉树中的节点数，最坏情况下，我们需要访问二叉树的所有节点
        /// 空间复杂度是O(n)。这是因为递归堆栈使用的最大空间位N。
        /// </summary>
        /// <param name="node"></param>
        /// <param name="p"></param>
        /// <param name="q"></param>
        /// <returns></returns>
        private TreeNode FindPOrQ(TreeNode node, TreeNode p, TreeNode q)
        {
            if (node == null)
            {
                return null;
            }
            if (node == p || node == q)
            {
                return node;
            }
            var left = FindPOrQ(node.left, p, q);
            var right = FindPOrQ(node.right, p, q);
            if (left == null)
            {
                return right;
            }
            if (right == null)
            {
                return left;
            }
            return node;
        }

        /// <summary>
        /// 第三种方法，遍历树，并且记录下遍历路径，当找到p或者q的任意一个时，将当前索引保存下，
        /// 继续遍历去寻找另外一个，并且保存遍历路径，如果遇到路径回退，并且回退到索引之后，索引自减，
        /// 直到找到另外一个之后，索引所处位置就是公共祖先位置。
        /// </summary>
        /// <param name="root"></param>
        /// <param name="p"></param>
        /// <param name="q"></param>
        /// <returns></returns>
        public TreeNode Path(TreeNode root, TreeNode p, TreeNode q)
        {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            var index = 0;
            var findP = false;
            var findQ = false;
            Find(root, p, q, stack, ref findP, ref findQ, ref index);
            while (stack.Count > index)
            {
                stack.Pop();
            }
            return stack.Pop();
        }

        private void Find(TreeNode current, TreeNode p, TreeNode q, Stack<TreeNode> stack, ref bool findP, ref bool findQ, ref int index)
        {
            stack.Push(current);
            if (!findP && !findQ)
            {
                index++;
            }
            if (current.val == p.val)
            {
                findP = true;
            }
            if (current.val == q.val)
            {
                findQ = true;
            }
            if (findP && findQ)
            {
                return;
            }
            if (current.left != null)
            {
                Find(current.left, p, q, stack, ref findP, ref findQ, ref index);
                if (findP && findQ)
                {
                    return;
                }
                stack.Pop();
                if (stack.Count < index)
                {
                    index--;
                }
            }
            if (current.right != null)
            {
                Find(current.right, p, q, stack, ref findP, ref findQ, ref index);
                if (findP && findQ)
                {
                    return;
                }
                stack.Pop();
                if (stack.Count < index)
                {
                    index--;
                }
            }
        }
    }
}
