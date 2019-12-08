using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy
{
    /// <summary>
    /// 590. N叉树的后序遍历
    /// </summary>
    public class Node
    {
        public int val;
        public IList<Node> children;

        public Node() { }
        public Node(int _val, IList<Node> _children)
        {
            val = _val;
            children = _children;
        }
    }

    public class NAryTreePostorderTraversal
    {
        public IList<int> Postorder(Node root)
        {
            List<int> res = new List<int>();
            Helper(root, res);
            return res;
        }

        public void Helper(Node root,List<int> res)
        {
            if (root == null) return;

            foreach(Node n in root.children){
                Helper(n, res);
            }

            res.Add(root.val);


        }
    }
}
