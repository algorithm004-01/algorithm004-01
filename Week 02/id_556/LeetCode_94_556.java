
// 传统递归方法
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    public void traverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                traverse(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                traverse(root.right, result);
            }
        }
    }
}	

// 参考题解中的染色法，通过栈进行递推
// 定义内部类包装TreeNode，但是因为类的操作需要额外开销，时间反而落后于递归
class Solution {
    class ColorNode {
        TreeNode node;
        String color;
        
        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
            
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));
        
        while(!stack.empty()){
            ColorNode cn = stack.pop();
            
            if(cn.color.equals("white")){
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }
        
        return res;
    }
}
