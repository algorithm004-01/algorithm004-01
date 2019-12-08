package com.leetcode.week02;

import com.leetcode.week02.util.Node;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_416 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        circelTreeNode(root,list);
        return list;
    }
    public void circelTreeNode(Node curr, List<Integer> list) {
        if(null != curr) {
            if(null != curr.children && curr.children.size() > 0 ) {
                for(Node node : curr.children) {
                    this.circelTreeNode(node,list);
                }
            }
            list.add(curr.val);
        }
    }
}
