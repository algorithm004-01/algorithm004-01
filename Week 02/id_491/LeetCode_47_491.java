class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }

        int i = 0;
        while (i < nums.length) {
            int[] tempList = Arrays.copyOf(nums, nums.length);
            tempList[i] = tempList[tempList.length - 1];
            tempList = Arrays.copyOf(tempList, tempList.length - 1);
            List<List<Integer>> resultTemp = permuteUnique(tempList);
            for (int j = 0; j < resultTemp.size(); j++) {
                resultTemp.get(j).add(0, nums[i]);
            }
            result.addAll(resultTemp);

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }

        return result;
    }
}
