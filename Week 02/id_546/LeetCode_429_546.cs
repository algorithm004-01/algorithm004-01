using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy
{
    /// <summary>
    /// 429. N叉树的层序遍历
    /// </summary>
    public class NAryTreeLevelOrderTraversal
    {
        List<List<int>> res = new List<List<int>>();
        Dictionary<int, IList<int>> dicList = new Dictionary<int, IList<int>>();

        /// <summary>
        /// 方法一：递归法，哈希表，遍历每一层，将层下标写入到哈希表中
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public IList<IList<int>> LevelOrder1(Node root)
        {
            Helper(root, 0);

            return dicList.Values.ToList();
        }

        public void Helper(Node root,int level){
            if (root == null) return;
            
            if(!dicList.ContainsKey(level))
            {
                dicList.Add(level, new List<int>());
            }
            dicList[level].Add(root.val);
            if (root.children != null)
            {
                foreach (Node n in root.children)
                {
                    Helper(n, level + 1);
                }

            }
        }


        /// <summary>
        /// 方法二：迭代法
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public IList<IList<int>> LevelOrder2(Node root)
        {
            IList<IList<int>> ret = new List<IList<int>>();
            if (root == null) return ret;

            Queue<Node> queue = new Queue<Node>();

            queue.Enqueue(root);//写入队列


            while (queue.Any())
            {
                List<int> curLevel = new List<int>();
                int len = queue.Count;
                for (int i = 0; i < len; i++)
                {
                    Node curr = queue.Dequeue();
                    curLevel.Add(curr.val);
                    foreach (Node c in curr.children)
                    {
                        queue.Enqueue(c);
                    }
                }
                ret.Add(curLevel);
            }

                       
            return ret;
        }


    }
}
