// 递归的方式
// 先遍历根节点，然后递归遍历左子树，再递归遍历右子树。

class Solution {
    List<Integer> listResults = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root == null)
            return listResults;
        listResults.add(root.val);
        for(Node child:root.children)
        {
            preorder(child);
        }
        return listResults;
    }
}