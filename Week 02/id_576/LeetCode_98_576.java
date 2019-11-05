import java.util.Stack;

import jdk.nashorn.api.tree.WhileLoopTree;

/**
 * LeetCode_98_576
 */
public class LeetCode_98_576 {
    public boolean isValidBST1(TreeNode root) {
        // return _jugeBST(0, root);
        return helper(root, null, null);
    }

    //错误思路实例
    private boolean _jugeBST1(int level, TreeNode root) {
         //termintor
         if (root.left == null && root.right == null) {
            return true;
        }
        // process current level logic
        // drill down
        /**
         错误的想法，并不是左结点的值小于根，右结点的值大于根就是二叉搜索树了
        是需要左子树都小于，右子树都大于！！
         */
        if (root.val > root.left.val ) _jugeBST(level + 1, root.left);
        if (root.val < root.right.val) _jugeBST(level + 1, root.right);
        // reverse states
        return false;
    }
    //递归法，o(n)
    private boolean helper1(TreeNode node, Integer lower, Integer upper) {
        //termintor and process current level
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        //drill down 
        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    //方法2: 迭代

    //方法3:中序遍历是递增的
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;
        System.out.println(inorder);
        

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    public static void main(String[] args) {
        LeetCode_98_576 l98 = new LeetCode_98_576();
        TreeNode root = new TreeNode(5);
        l98.isValidBST2(root);
    }
    
}