package id_511;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0
 * @Description: 二叉树的中序遍历
 * @author: bingyu
 * @date: 2019/10/30 23:23
 */
public class LeetCode_94_511 {

    public static class TreeNode{
        public int val;
        public TreeNode left,right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    //方法一：递归
    //前序遍历
    public void preOrder(TreeNode root, List<Integer> list){
        if (root != null) {  //如果根结点不为空
            list.add(root.val);
            if (root.left != null) { //如果左结点不为null，则将该左结点作为根结点继续遍历它的左结点
                preOrder(root.left,list);
            }
            //开始遍历右结点
            if (root.right != null) {
                preOrder(root.right,list);
            }
        }
    }

    //中序遍历
    public void inOrder(TreeNode root, List<Integer> list){
        if (root != null) {  //如果根结点不为空
            if (root.left != null) { //如果左结点不为null，则将该左结点作为根结点继续遍历它的左结点
                inOrder(root.left,list);
            }
            //执行到这里说明root.left==null，即左节点已遍历完成
            list.add(root.val);
            //开始遍历右结点
            if (root.right != null) {
                inOrder(root.right,list);
            }
        }
    }

    //后序遍历
    public void postOrder(TreeNode root, List<Integer> list){
        if (root != null) {  //如果根结点不为空
            if (root.left != null) { //如果左结点不为null，则将该左结点作为根结点继续遍历它的左结点
                postOrder(root.left,list);
            }
            //开始遍历右结点
            if (root.right != null) {
                postOrder(root.right,list);
            }
            list.add(root.val);
        }
    }

    //方法二：使用栈来模拟递归
    public static List <Integer> inorderTraversal2(TreeNode root) {
        List <Integer> res = new ArrayList <> ();
        Stack <TreeNode> stack = new Stack <> ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) { //这里外层的循环条件中的curr!=null是判断当前节点是否存在右子树，下面内存循环的curr!=null是判断当前节点是否存在左子树
            while (curr != null) { //首先在这里第一次循环是将根结点的所有左子树结点放入栈中，第一次内层while循环完后，cur就是整个树最左边的叶子结点
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop(); //执行到这里说明curr是某个结点的左叶子结点(即左边没有子元素了)，下面可以开始遍历其右子树
            res.add(curr.val);
            curr = curr.right; //遍历右子树
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(1);
        TreeNode j = new TreeNode(0);
        TreeNode k = new TreeNode(-1);
        TreeNode l = new TreeNode(11);
        root.left = a;
        root.left.right = b;
        root.left.left = c;
        root.left.left.left = d;
        root.left.left.right = e;
        root.left.right.left = f;
        root.left.right.right = g;
        root.right = h;
        root.right.left = i;
        root.right.right = j;
        root.right.right.left = k;
        root.left.left.left.right = l;
        List<Integer> list = inorderTraversal2(root);
        System.out.println(list);
    }
}
