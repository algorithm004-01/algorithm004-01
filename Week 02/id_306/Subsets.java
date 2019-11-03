import java.util.ArrayList;
import java.util.List;

/**
 * Created by LynnSun on 2019/10/27.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        if(null==nums){
            return ans;
        }
        helper(ans,nums,new ArrayList<Integer>() ,0);
        return ans;
    }

    private void helper(List<List<Integer>> ans,int[]nums,List<Integer> list ,int index){
        // terminator
        if(index==nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        // not pick the number at this index
        helper(ans,nums,list ,index+1);
        list.add(nums[index]);
        // not pick the number at this index
        helper(ans,nums,list ,index+1);
        // reverse the current state
        list.remove(list.size()-1);
    }
}
