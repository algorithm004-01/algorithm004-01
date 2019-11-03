/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        _permutations(new int[nums.length], nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void _permutations( int[] visited, 
                                int[] nums, 
                                ArrayList<Integer> current,
                                List<List<Integer>> result){
        //terminator
        if (current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        //current process
        for(int i = 0; i < nums.length; i++){
            if(visited[i]==1){continue;}
            visited[i]=1;
            current.add(nums[i]);
            //drill down
            _permutations(visited, nums, current, result);
            //reverse
            visited[i]=0;
            current.remove(current.size()-1);
        }
        
    }
}
// @lc code=end
//全排列 回溯方式，每一位置一个标志位，如果是1 ，不在加入自己，如果不是加入自己并置为1
