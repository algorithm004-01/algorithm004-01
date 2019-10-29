import java.util.ArrayList;
import java.util.List;

public class LeetCode_46_Permutations {
    public static void main(String[] args) {
        Solution solution = new LeetCode_46_Permutations().new Solution();
    }


    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            permuteRec(0, nums.length, nums, new ArrayList<>(), res);
            return res;
        }

        private void permuteRec(int level, int max, int[] nums, List<Integer> list, List<List<Integer>> res) {

            if (level == max) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i : nums) {
                if (list.contains(i)) continue;
                list.add(i);
                permuteRec(level + 1, max, nums, list, res);
                list.remove(level);
            }
        }
    }
}