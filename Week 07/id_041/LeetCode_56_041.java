package LeetCode_56_041;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public int[][] merge(int[][] intervals){
        LinkedList<int[]> result = new LinkedList<>();
        if(intervals == null || intervals.length == 0) return result.toArray(new int[0][]);
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[]o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < intervals.length;i++ ){
            if(result.isEmpty() || result.getLast()[1] < intervals[i][0]){
                result.add(intervals[i]);
            }else{
                result.getLast()[i] = Math.max(result.getLast()[1],intervals[i][1]);
            }
        }
        return result.toArray(new int[0][0]);
    }
}
