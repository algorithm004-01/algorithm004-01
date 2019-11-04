using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy
{
    /// <summary>
    /// 589. N叉树的前序遍历
    /// </summary>
    public class NAryTreePreorderTraversal
    {
        List<int> res = new List<int>();
        public IList<int> Preorder(Node root)
        {
            if (root == null) return res;

            res.Add(root.val);

            foreach(Node n in root.children){
                Preorder(n);
            }

            return res;
        }
    }
}
