/**
 * Definition for a binary tree node. */
 public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }
  }

public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        var levels = new List<IList<int>>();
        if(root == null){
            return levels;
        }
        
        void Helper(TreeNode node, int level){
            if(levels.Count == level){
                levels.Add(new List<int>());
            }
            levels[level].Add(node.val);
            
            if(node.left != null){
                Helper(node.left, level + 1);
            }
            if(node.right != null){
                Helper(node.right, level + 1);
            }
        }
        
        Helper(root, 0);
        return levels;
    }
}