package week01;

public class RemoveDuplicates26 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public int removeDuplicates(int[] nums) {
	    if (nums.length == 0) {
	    	return 0;
	    }
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
}
