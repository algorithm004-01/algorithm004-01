package homework.week02;

import java.util.ArrayList;
import java.util.List;

import homework.week02.beans.TreeNode;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreOrderTree{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        treeFor(root, result);
        return result;
    }

    public void treeFor(TreeNode root,List<Integer> result){
        if(root != null){
            result.add(root.val);
            if(root.left != null){
                treeFor(root.left,result);
            }
            
            if(root.right != null){
                treeFor(root.right, result);
            }

        }
    }
}