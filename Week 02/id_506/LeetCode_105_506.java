class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || preorder.length != inorder.length){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]){
                rootIndex = i;
            }
        }

        int leftLength = rootIndex;
        int rightLength = preorder.length - rootIndex -1;

        if (leftLength > 0) {
            int[] leftPre = new int[leftLength];
            int[] leftIn = new int[leftLength];

            System.arraycopy(preorder, 1, leftPre, 0,  leftLength);
            System.arraycopy(inorder, 0, leftIn, 0, leftLength);

            root.left = buildTree(leftPre, leftIn);
        }

        if (rightLength > 0){

            int[] rightPre = new int[rightLength];
            int[] rightIn = new int[rightLength];


            System.arraycopy(preorder, rootIndex + 1, rightPre, 0, rightLength);
            System.arraycopy(inorder, rootIndex + 1, rightIn, 0, rightLength);


            root.right = buildTree(rightPre, rightIn);
        }



        return root;
    }