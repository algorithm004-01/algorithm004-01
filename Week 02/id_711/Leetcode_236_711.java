package Week2;

import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Leetcode_236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        Leetcode_236 ll = new Leetcode_236();
        TreeNode ancestor = ll.lowestCommonAncestor4(root, root.left, root.right);
        System.out.println(ancestor.val);
    }



    /**
     * 沙雕暴力解法
     * 执行用时 :23 ms, 在所有 java 提交中击败了16.80%的用户
     * 内存消耗 :39.9 MB, 在所有 java 提交中击败了5.04%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,Integer> mapleft = new HashMap<>();
        Map<TreeNode,Integer> mapright = new HashMap<>();
        find(mapleft,root,p,1);
        find(mapright,root,q,1);
        TreeNode ans = root;
        for (TreeNode node:mapright.keySet()) {
            if (mapleft.containsKey(node) && mapleft.get(node) > mapleft.get(ans)){
                ans = node;
            }
        }
        return ans;
    }

    private static boolean find(Map<TreeNode, Integer> map, TreeNode root, TreeNode left, int height) {
        if (root == null)
            return false;
        if (root.val == left.val) {
            map.put(root, height);
            return true;
        }
        if (find(map, root.left, left, height + 1)) {
            map.put(root, height);
            return true;
        }
        if (find(map, root.right, left, height + 1)) {
            map.put(root, height);
            return true;
        }
        return false;
    }

    /**
     * 题解4行解法
     * 执行用时 :9 ms, 在所有 java 提交中击败了97.44%的用户
     * 内存消耗 :35.8 MB, 在所有 java 提交中击败了80.75%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor4(root.left, p, q);
        TreeNode right = lowestCommonAncestor4(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    /**
     * 题解递归方法，用了全局变量
     * 执行用时 :9 ms, 在所有 java 提交中击败了97.42%的用户
     * 内存消耗 :36.2 MB, 在所有 java 提交中击败了76.96%的用户
     */
    
    private TreeNode ans;
    public Leetcode_236() {
        this.ans = null;
    }
    
    private TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root,p,q);
        return this.ans;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        int left = recurseTree(root.left, p, q) ? 1 : 0;

        int right = recurseTree(root.right, p, q) ? 1 : 0;

        int mid = (root == p || root == q) ? 1 : 0;
        if (mid + left + right > 1) {
            this.ans = root;
        }
        return (mid + left + right > 0);
    }

    /**
     * 题解父指针解法
     * 执行用时 :19 ms, 在所有 java 提交中击败了21.80%的用户
     * 内存消耗 :36.4 MB, 在所有 java 提交中击败了72.86%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root,null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }

    /**
     * 题解无父指针迭代（没想到很慢。。。。）
     * 执行用时 :27 ms, 在所有 java 提交中击败了14.18%的用户
     * 内存消耗 :36.5 MB, 在所有 java 提交中击败了72.40%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */

    private static int BOTH_PENDING = 2;
    private static int LEFT_DONE = 1;
    private static int RIGHT_DONE = 0;

    private TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root,2));
        boolean one_note_found = false;
        TreeNode LCA = null;

        TreeNode childNode = null;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent = top.getKey();
            int parentState = top.getValue();

            if (parentState != 0) {
                if (parentState == 2) {
                    if (parent == p || parent == q) {
                        if (one_note_found) {
                            return LCA;
                        }
                        else {
                            one_note_found = true;
                            LCA = stack.peek().getKey();
                        }
                    }
                    childNode = parent.left;
                }
                else {
                    childNode = parent.right;
                }
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent, parentState - 1));

                if (childNode != null) {
                    stack.push(new Pair<TreeNode, Integer>(childNode, 2));
                }
            }
            else {
                if (LCA == stack.pop().getKey() && one_note_found) {
                    LCA = stack.peek().getKey();
                }
            }
        }
        return null;
    }
}
