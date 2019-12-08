class Solution {
    // 类似括号生成器的思想，每个元素往前面元素的排列组合里加
    // 符合条件的输出
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        addElem(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void addElem(List<List<Integer>> list, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length ){
            list.add(new ArrayList<>(tempList));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            addElem(list, tempList, nums);
            tempList.remove(tempList.size()-1);
        }
        
    }
}
