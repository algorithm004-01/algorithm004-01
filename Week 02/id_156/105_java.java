class Solution {
    int[] preOrder;
    int[] inOrder;
    int preIndex = 0;

    HashMap<Integer, Integer> array2Dict = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inOrder = inorder;
        this.preOrder = preorder;
        int index = 0;

        for (Integer val : inorder) {
            array2Dict.put(val,index);
            index++;
        }
        return BuildTree(0, inorder.length);
    }

    /* 递归调用--构建树 */
    private TreeNode BuildTree(int left, int right) {
        //terminator
        if (left >= right) {
            return null;
        }
        //process
        int rootVal = preOrder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        preIndex++;               

        int rootIndex = array2Dict.get(rootVal);

        root.left = BuildTree(left, rootIndex);
        root.right = BuildTree(rootIndex + 1, right);

        return root;
    }
}
