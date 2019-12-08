package inordertraversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Inorder94 {
	int val;
	Inorder94 left;
	Inorder94 right;

	Inorder94(int x) {
		val = x;
	}
/*
 * 方法1：递归
 * 方法2：非递归
 */
	public List<Integer> inorderTraversal1(Inorder94 root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		result.addAll(inorderTraversal1(root.left));
		result.add(root.val);
		result.addAll(inorderTraversal1(root.right));
		return result;
	}
/*
 * -----------------------------------------------------------分割线	
 */
	
	public List<Integer> inorderTraversal2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		TreeNode now = root;
		while (now != null || !stack.isEmpty()) {
			while (now != null) {
				stack.push(now);
				now = now.left;
			}
			now = stack.pop();
			list.add(now.val);
			now = now.right;

		}
		return list;
	}

}
