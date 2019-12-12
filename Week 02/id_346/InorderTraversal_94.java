import java.util.ArrayList;
import java.util.List;

/**
 * @auther: TKQ
 * @Title: InorderTraversal_94
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-11-02 10:06
 */
public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        helper(root,result);
        return result;
    }

    public void helper(TreeNode root,List<Integer> result){
        if(root!=null){
            if(root.left!=null){
                helper(root.left,result);
            }
            result.add(root.val);
            if(root.right!=null){
                helper(root.right,result);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
