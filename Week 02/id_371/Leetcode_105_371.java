import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:29
 **/

public class Leetcode_105_371 {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 仿解1:分治+哈希表
     *
     * @author Shaobo.Qian
     * @date 2019/11/6
     * @myProblem (因为一开始没理解为什么需要前序遍历数组和中序遍历数组才能确定树的样子)
     * @link https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    /**
     * @param preorder 前序数组
     * @param p_start  前序数组的头指针
     * @param p_end    前序数组的尾指针
     * @param inorder  中序数组
     * @param i_start  中序数组的头指针
     * @param i_end    中序数组的尾指针
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, Map<Integer, Integer> map) {
        //1.递归出口(preorder 为空,返回 null)
        if (p_start == p_end) return null;

        //2.1处理当前层逻辑,分治,构建根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //确定左子树的数量
        int i_root_index = map.get(root_val);
       /* int i_root_index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }*/
        int leftNum = i_root_index - i_start;
        //2.2处理当前层逻辑,分治,构建左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
        //2.3处理当前层逻辑,分治,构建右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
        //3.合并子问题的结果,返回
        return root;
    }

}
