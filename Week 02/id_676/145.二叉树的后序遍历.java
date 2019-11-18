import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

  /*
 *思路：1.使用递归的方法实现，时间复杂度为O(n)
 * 2.使用栈的方法实现，时间复杂度为O(n)
 */

 //使用递归来实现
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }

            if (root.right != null) {
                helper(root.right, res);
            }
            res.add(root.val);
        }
    }
}
// @lc code=end

//使用栈：
class SolutionTwo {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0,cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return res;
    }
}

/*
*使用栈来实现前序，中序和后序遍历
*/
//inorder
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res=new ArrayList<>();
    if (root==null) return res;

    Stack<TreeNode> stack=new Stack<>();
    TreeNode curr=root;

    while(curr!=null || !stack.isEmpty()){
        while (curr!=null){
            stack.push(curr);
            curr=curr.left;
        }
        curr=stack.pop();
        res.add(curr.val);
        curr=curr.right;
    }
    return res;
}

//preorder
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
        TreeNode current = stack.pop();
        list.add(current.val);
        if(current.right!=null) {
           stack.push(current.right);
        }
        if(current.left!=null) {
          stack.push(current.left);
        }
    }
    return list;
}

//postorder
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
        TreeNode curr = stack.pop();
        list.add(0,curr.val);
        if(curr.left!=null) {
          stack.push(curr.left);
        }
        if(curr.right!=null) {
           stack.push(curr.right); 
        }
    }
    return list;
}

/* 
*使用队列来实现前序、中序和后序遍历
*/

//proorder
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.add(p.val);  // Add before going to children
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            p = node.right;   
        }
    }
    return result;
}

//inorder
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            result.add(node.val);  // Add after all left children
            p = node.right;   
        }
    }
    return result;
}

//postorder
public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.addFirst(p.val);  // Reverse the process of preorder
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
}