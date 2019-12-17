
// https://leetcode-cn.com/problems/validate-binary-search-tree
// 验证二叉搜索树

public class LeetCode_98_716 {

    // 1. 递归实现
    // 重复子问题：当前节点的值是其左子树的上限，是其右子树的下限
    public boolean isValidBST11(TreeNode root) {
        return isValid(root, null, null);
    }
    
    // low 表示右子树的下限，不能比他小
    // high 表示左子树的上限，不能比他大
    private boolean isValid(TreeNode node, Integer low, Integer high) {
        // terminator
        if (node == null) return true;
        
        // process current logic
        int val = node.val;
        // 在右子树中每个节点都要大于low，出现小于low的就返回false
        if (low != null && val <= low) return false;
        // 在左子树中每个节点都要小于high，出现大于high的就返回false
        if (high != null && val >= high) return false;
        
        // drill down
        // 陷入下一层，进入的是左子树，如果下一层直接返回了不合法，就提前终止递归，返回不合法
        if (!isValid(node.left, low, val)) return false;
        // 陷入下一层，进入的是右子树，如果下一层直接返回了不合法，就提前终止递归，返回不合法
        if (!isValid(node.right, val, high)) return false;
        
        // default terminator，正常返回合法
        return true;
    }

    // 1.2 更加优雅的写法, 简洁一些
    public boolean isValidBST12(TreeNode root) {
        return validBSTHelper(root, null, null);
    }

    private boolean validBSTHelper(TreeNode node, TreeNode low, TreeNode high) {
        // terminator
        if (node == null) return true;
        // process current logic
        if ((low != null && node.val <= low.val) || (high != null && node.val >= high.val)) return false;
        // drill down
        return validBSTHelper(node.left, low, node) && validBSTHelper(node.right, node, high);
    }
    
    // 2. 利用中序遍历二叉树输出有序序列的特性
    // 这种方式肯定不如直接递归法
    public boolean isValidBST21(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        
        // 要保证顺序性
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    private void inorder(TreeNode node, List<Integer> res) {
        if (node != null) {
            // 加上 if (node.left != null) 的判断，少一层递归
            inorder(node.left, res);
            res.add(node.val);
            inorder(node.right, res);
        }
    }
    
    // 2.2 使用另外一种优化的做法
    // 用 BST 的中序遍历保证前一个节点都小于当前节点
    public boolean isValidBST22(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 左子树
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 当前节点
            curr = stack.pop();
            if (prev != null && curr.val <= prev.val) 
                return false;
            prev = curr;
            // 右节点
            curr = curr.right;
        }
        
        return true;
    }
    
    // 2.3 中序递归的写法
    private TreeNode prev;
    public boolean isValidBST23(TreeNode root) {
        // terminator
        if (root == null) return true;
        
        // drill down, to left
        if (!isValidBST23(root.left)) return false;
        
        // process current logic
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        
        // drill down, to right
        if (!isValidBST23(root.right)) return false;
        
        // terminator
        return true;
    }
    
    // 3. 迭代法, 将递归的实现使用loop的方式进行实现
    public boolean isValidBST3(TreeNode root) {
        // todo
        return false;
    }
}