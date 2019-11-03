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
    
    HashMap<Integer,Integer> map = new HashMap();
    int[] preorder ;
    
    //使用hashset保存前序遍历，加快查询效率
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if(preLen != inLen){
            return null;
        }
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(0,preLen-1,0,inLen);
    }
    
    public TreeNode buildTree( int preLeft, int preRight, int inLeft, int inRight){
        //终止条件
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        
        //根据前序遍历,找到跟节点位置,并生成跟节点
        int rootVal = preorder[preLeft];
        TreeNode rootNode = new TreeNode(rootVal);
        //找到下一层级的跟节点位置
        int nextRootIdx = map.get(rootVal);
        
        rootNode.left = buildTree(preLeft + 1, nextRootIdx + preLeft -inLeft, inLeft, nextRootIdx -1);
        rootNode.right = buildTree(nextRootIdx + preLeft -inLeft +1, preRight, nextRootIdx + 1,inRight );
            
        return rootNode;
    }
    
}