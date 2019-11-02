package homework.week02;

import java.util.ArrayList;
import java.util.List;

import homework.week02.beans.TreeNode;

/**
 * 94. 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InOrderTree{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        treeFor(root, result);
        return result;
    }

    // 先左，后右
    public void treeFor(TreeNode root,List<Integer> result){
        if(root != null){
            if(root.left != null){
                treeFor(root.left,result);
            }
            result.add(root.val);
            if(root.right != null){
                treeFor(root.right, result);
            }

        }
    }

}