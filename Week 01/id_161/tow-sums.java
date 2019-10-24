

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> Solution(int[] nums) {

        int[] ret = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                ret[0] = hash.get(nums[i]);
                ret[1] = i;
                break;
            }
            hash.put(target - nums[i], i);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
