class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        
        if(nums.length > 0) { 
            int[] arr = new int[nums.length];
            arr[0] = nums[0];
            //System.out.println("arr[0], " + arr[0]);
            for(int i = 0; i < nums.length; i++) {
                for(int j = i; j < nums.length; j++) {
                    if(i != j && nums[i] != nums[j]) {
                        arr[++count] = nums[j];
                        nums[count] = arr[count];
                        break;
                    } else {
                        i = j;
                    }
                }
            }
        } else {
            return 0;
        }
        
        int[] a = new int[count+1];
        nums = a;
        
        return nums.length;
    }
}
