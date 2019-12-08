class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        } 

        int steps = 0;
        List<Integer> stepsList = new ArrayList<>();
        stepsList.add(0);
        int maxIndex = 0;
        while(steps < nums.length - 1 && stepsList.size() > 0) {
            steps++;
            List<Integer> tempList = new ArrayList<>();
            for(int j = 0; j < stepsList.size(); j++) {
                int index = stepsList.get(j);
                for(int i = nums[index]; i + index > maxIndex; i--) {
                    if(index + i >= nums.length - 1){
                        return steps;
                    } 

                    tempList.add(index + i);
                }
                maxIndex = nums[index] + index;
            }

            stepsList = tempList;
        }

        return -1;
    }
}
