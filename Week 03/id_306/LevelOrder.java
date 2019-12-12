import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LynnSun on 2019/10/28.
 * 力扣题目地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 */
public class LevelOrder {

    /**
     * 广度优先搜索，用队列完成
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_bfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 队列
        Deque<TreeNode> treeNodeQueque=new LinkedList<>();
        // 先保存第一个元素
        treeNodeQueque.add(root);
        // 队列不为空进行循环，同时也是结束条件
        while (!treeNodeQueque.isEmpty()){
            // 保存每一层的输出结果
            List<Integer> tmpOutList = new ArrayList<>();
            // 这里必须如此，不然for循环会改变treeNodeQueque.size()的值
            int queueSize=treeNodeQueque.size();
            // 循环取出队列中的元素
            for(int i=0;i<queueSize;i++){
                // 取出元素
                TreeNode node=treeNodeQueque.poll();
                // 保存值
                tmpOutList.add(node.val);
                //如果有左节点，保存在队列中
                if (node.left != null) treeNodeQueque.add(node.left);
                //如果有右节点，保存在队列中
                if (node.right != null) treeNodeQueque.add(node.right);
            }
            // 将每一层得到的结果保存到最后要输出的大结果中
            res.add(tmpOutList);
        }
        return res;
    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_dfs(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        dfs_helper(root, 0,levels);
        return levels;
    }

    /**
     * 递归遍历左右分支树，但是需要传当前深度（层），这样出栈时就可以确定自己的层并保存正确
     * @param node
     * @param level
     * @param levels
     */
    private void dfs_helper(TreeNode node,int level,List<List<Integer>> levels){
        // 给每一层构建一个保存节点数据的List
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());
        // 保存此节点数据
        levels.get(level).add(node.val);
        // 如果左分支有下一层 继续递归遍历
        if (node.left != null)
            dfs_helper(node.left, level + 1,levels);
        // 如果右分支有下一层 继续递归遍历
        if (node.right != null)
            dfs_helper(node.right, level + 1,levels);
    }
}
