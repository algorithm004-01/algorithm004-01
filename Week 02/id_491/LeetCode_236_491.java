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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> plist = this.getParentList(root, p);
        List<TreeNode> qlist = this.getParentList(root, q);
        System.out.println(plist.size());
        System.out.println(qlist.size());
        TreeNode temp = null;
        for(int i = 0; i < plist.size() && i < qlist.size(); i++){
            if(plist.get(plist.size() - 1 - i) == qlist.get(qlist.size() - 1 - i)){
                temp = plist.get(plist.size() - 1 - i);
            } else {
                break;
            }
        }
        return temp;
    }

    public List<TreeNode> getParentList(TreeNode root, TreeNode p) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null){
            return result;
        } else if(root == p){
            result.add(p);
        } else {
            List<TreeNode> tempLeft =  this.getParentList(root.left, p); 
            if(tempLeft.size() != 0){
                result.addAll(tempLeft);
                result.add(root);
            } else {
                List<TreeNode> tempRight = this.getParentList(root.right, p);
                if(tempRight.size() > 0){
                    result.addAll(tempRight);
                    result.add(root);
                }
            }
        }

        return result;
    }
}
