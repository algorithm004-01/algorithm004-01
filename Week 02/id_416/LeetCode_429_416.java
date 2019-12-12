package com.leetcode.week02;

import com.leetcode.week02.util.Node;

import java.util.*;

public class LeetCode_429_416 {
    //队列
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(null == root) return ret;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);//压入队列
        while(!queue.isEmpty()) {
            List<Integer> list = new LinkedList<Integer>();
            int len = queue.size();
            for(int i = 0; i<len ; i++) {
                Node curr = queue.poll();//弹出队列
                list.add(curr.val);//当前层所有值存起来
                for(Node chi : curr.children)  queue.offer(chi);//压入队列中
            }
            ret.add(list);
        }
        return ret;
    }

    //递归
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(root.val));
        circleLevelNode(root.children,list);
        return list;
    }
    public void circleLevelNode(List<Node> children,List<List<Integer>> list) {
        if(null != children && children.size() > 0 ) {
            List<Node> childrenSecond = new ArrayList<Node>();
            List<Integer> rList = new ArrayList<Integer>();
            for(Node c : children) {//所有子节点存入
                rList.add(c.val);
                if(null != c.children && c.children.size() > 0 ) {
                    childrenSecond.addAll(c.children);//所有子节点的子节点存入
                }
            }
            list.add(rList);
            circleLevelNode(childrenSecond,list);
        }
    }
}
