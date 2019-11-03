package com.leetcode.week02;

import com.leetcode.week02.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_144_416 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        _circleTreeNode(root,list);
        return list;
    }

    private void _circleTreeNode(TreeNode root, List<Integer> list) {
        if(null != root) {
            list.add(root.val);

            if(null != root.left) {
                _circleTreeNode(root.left,list);
            }

            if(null != root.right) {
                _circleTreeNode(root.right,list);
            }

        }
    }
}
