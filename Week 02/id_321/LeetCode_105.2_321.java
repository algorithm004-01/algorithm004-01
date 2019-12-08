package inordertraversal;

public class Buildtree105second {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		// hash[root] = inIndex
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}

	// preorder: root (1), left(len1), right(len2)	// root(0); 1, len1; len1 + 1, len1 + len2 - 1
	// preorder: 1, len1;-->len1
	// inorder:  0, len1 - 1;-->len1
	// inorder: left(len1), root (1), right(len2)	// 0, len1 - 1; root(len1); len1 + 1, len1 + len2 - 1
	
	// preorder: preStart
	// inorder:  inStart, inEnd
}
