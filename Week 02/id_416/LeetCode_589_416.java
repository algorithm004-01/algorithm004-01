package com.leetcode.week02;

import com.leetcode.week02.util.Node;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_416 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        circleTreeNode(root,list);
        return list;
    }
    public void circleTreeNode(Node node,List<Integer> list) {
        if(null != node) {
            list.add(node.val);//根
            List<Node> c = node.children;
            if(null != c) {
                for(int i = 0;i<c.size();i++) {
                    circleTreeNode(c.get(i),list);
                }
            }
        }
    }
}
