/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> largestValues(TreeNode root) {
        getRowNums(root,0);
        return res;
    }
    
    private void getRowNums(TreeNode node, int rowLevel){
        if(node != null){
            if(res.size() == rowLevel){
                res.add(node.val);
            } else {
                // 改善：保持每个深度放入的元素为当前遍历中最大
                res.set(rowLevel,Math.max(res.get(rowLevel),node.val));
            }
            if(node.left != null) getRowNums(node.left,rowLevel+1);
            if(node.right != null) getRowNums(node.right,rowLevel+1);
        }
    }
}