import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther: TKQ
 * @Title: LevelOrder_429
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-11-02 12:17
 */
public class LevelOrder_429 {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curRes = new ArrayList<>(size);
            for(int i=size;i>0;i--){
                Node node = queue.poll();
                curRes.add(node.val);
                if(node.children!=null){
                    for(int j=0;j<node.children.size();j++){
                        queue.offer(node.children.get(j));
                    }
                }
            }
            result.add(curRes);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
