/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * #1
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        int level = 0;
        boolean preNodeNull = true;
        ArrayList<Integer> maxNums = new ArrayList();
        travelNode(root, maxNums, level);
        return maxNums;
    }

    public void travelNode(TreeNode current, ArrayList<Integer> maxNums, int level) {
        if (current == null)
            return;
        if (maxNums.size() <= level) {
            maxNums.add(current.val);
        } else if (current.val > maxNums.get(level)) {
            maxNums.set(level, current.val);
        }
        travelNode(current.left, maxNums, level + 1);
        travelNode(current.right, maxNums, level + 1);
    }

    public List<Integer> largestValues1(TreeNode root) {
        int maxNum = 0;
        boolean preNodeNull = true;
        ArrayList<Integer> maxNums = new ArrayList();
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        TreeNode current;
        nodes.add(root);
        nodes.add(null);
        while (true) {
            current = nodes.poll();
            if (current == null) {
                if (preNodeNull) {
                    break;
                }
                maxNums.add(maxNum);
                nodes.add(null);
                preNodeNull = true;
                continue;
            }
            if (preNodeNull) {
                preNodeNull = false;
                maxNum = current.val;
            } else if (current.val > maxNum) {
                maxNum = current.val;
            }
            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }
        return maxNums;
    }

    public List<Integer> largestValues2(TreeNode root) {
        int maxNum, size = 0;
        TreeNode current;
        ArrayList<Integer> maxNums = new ArrayList();
        if (root == null)
            return maxNums;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            size = nodes.size();
            maxNum = Integer.MIN_VALUE;
            while (size-- > 0) {
                current = nodes.poll();
                if (current.val > maxNum)
                    maxNum = current.val;
                if (current.left != null)
                    nodes.add(current.left);
                if (current.right != null)
                    nodes.add(current.right);
            }
            maxNums.add(maxNum);
        }
        return maxNums;
    }
}