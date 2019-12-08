package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther: TKQ
 * @Title: Permute_46
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Company:
 * @Created: 2019-11-02 16:26
 */
public class Permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if(len == 0){
            return res;
        }
        genPermution(nums,used,0,len,new Stack<>(),res);
        return res;
    }

    private void genPermution(int[] nums,boolean[] visited,int curSize,int len,Stack<Integer> path,List<List<Integer>> res){
        if(curSize  == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<len;i++){
            if(!visited[i]){
                path.push(nums[i]);
                visited[i] = true;
                genPermution(nums,visited,curSize +1,len,path,res);
                path.pop();
                visited[i] = false;
            }
        }
    }
}
