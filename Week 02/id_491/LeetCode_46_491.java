class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] tempList = Arrays.copyOf(nums, nums.length);
            tempList[i] = tempList[tempList.length - 1];
            tempList = Arrays.copyOf(tempList, tempList.length - 1);
            List<List<Integer>> resultTemp = permute(tempList);
            for (int j = 0; j < resultTemp.size(); j++) {
                resultTemp.get(j).add(0, nums[i]);
            }
            result.addAll(resultTemp);
        }

        return result;
    }
}
