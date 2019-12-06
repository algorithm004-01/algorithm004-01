// 问题化解为一个数num查找target-num是否存在于数组中
public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hash = new HashMap<>();
    int[] ret = new int[2];
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        int wanted = target - num;
        Integer wantedIndex = hash.get(num);
        if (wantedIndex != null){
            ret[0] = wantedIndex;
            ret[1] = i;
            return ret;
        }
        hash.put(wanted, i);
    }
    return ret;
}