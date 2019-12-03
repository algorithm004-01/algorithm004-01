using System.Collections.Generic;
using Poplar.Algorithm.Models;

namespace Poplar.Algorithm.WeekTwo
{
    /// <summary>
    /// N叉树的层序遍历
    /// https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
    /// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/submissions/
    /// </summary>
    public class NAryTreeLevelOrderTraversalSol
    {
        /// <summary>
        /// 迭代
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public IList<IList<int>> LevelOrder(Node root)
        {
            var result = new List<IList<int>>();
            if (root == null)
            {
                return result;
            }
            var current = new Queue<Node>();
            current.Enqueue(root);
            while (current.Count != 0)
            {
                var container = new List<int>();
                var next = new Queue<Node>();
                while (current.Count != 0)
                {
                    var node = current.Dequeue();
                    container.Add(node.val);
                    foreach (var item in node.children)
                    {
                        next.Enqueue(item);
                    }
                }
                result.Add(container);
                current = next;
            }
            return result;
        }
    }
}
