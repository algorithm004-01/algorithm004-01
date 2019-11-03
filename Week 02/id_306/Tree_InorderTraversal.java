import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by LynnSun on 2019/10/23.
 */
public class Tree_InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        center_helper(root,arrayList);
        return arrayList;
    }

    /**
     * 递归，中序遍历
     * @param root
     * @param list
     */
    private void center_helper(TreeNode root,List<Integer> list){
        if(null!=root){
            if(null!=root.left){
                center_helper(root.left,list);
            }
            list.add(root.val);
            if(null!=root.right){
                center_helper(root.right,list);
            }
        }
    }

    /**
     * 树遍历，用栈的方式，迭代，中序
     * @param root
     * @return
     */
    public List < Integer > inorderTraversal_stack(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 递归，前序遍历
     * @param root
     * @param list
     */
    private void pre_helper(TreeNode root,List<Integer> list){
        if(null!=root){
            list.add(root.val);
            if(null!=root.left){
                pre_helper(root.left,list);
            }
            if(null!=root.right){
                pre_helper(root.right,list);
            }
        }
    }

    /**
     * 迭代，前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        List<Integer> list = new ArrayList<Integer>();
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            list.add(node.val);
            if(node.right != null)
                nodeStack.push(node.right);
            if(node.left != null)
                nodeStack.push(node.left);
        }
        return list;

    }

    /**
     * 递归，后序遍历
     * @param root
     * @param list
     */
    private void post_helper(TreeNode root,List<Integer> list){
        if(null!=root){
            if(null!=root.left){
                post_helper(root.left,list);
            }
            if(null!=root.right){
                post_helper(root.right,list);
            }
            list.add(root.val);
        }
    }

    /**
     * 迭代，后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            list.add(curr.val);
            if(curr.left != null)
                nodeStack.push(curr.left);
            if(curr.right != null)
                nodeStack.push(curr.right);
        }
        Collections.reverse(list);
        return list;
    }
}
