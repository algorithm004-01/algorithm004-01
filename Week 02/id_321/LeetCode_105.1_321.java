package inordertraversal;

public class Buildtree105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}

		TreeNode result = new TreeNode(preorder[0]);
		if (preorder.length == 1) {
			return result;
		}
		int top = 0;
		for (top = 0; top < inorder.length; top++) {
			if (inorder[top] == preorder[0]) {
				break;
			}
		}
		int[] left_preorder = new int[top];
		int[] left_inorder = new int[top];
		int[] right_preorder = new int[preorder.length - top - 1];
		int[] right_inorder = new int[preorder.length - top - 1];

		for (int i = 0; i < top; i++) {
			left_preorder[i] = preorder[i + 1];
			left_inorder[i] = inorder[i];
		}
		result.left = buildTree(left_preorder, left_inorder);
		
		for (int i = 0; i < preorder.length - top - 1; i++) {
			right_preorder[i] = preorder[i + top + 1];
			right_inorder[i] = inorder[i + top + 1];
		}
		result.right = buildTree(right_preorder, right_inorder);
		return result;
	}
}
