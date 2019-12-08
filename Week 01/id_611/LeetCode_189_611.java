class Solution {
    //环形替换法
    public void rotate(int[] nums, int k) {
        //提取k位置
        k = k % nums.length;
        //位移次数
        int count =  0;
        for(int start = 0; count < nums.length; start++){
            //前置变量
            int prev = nums[start];
            //当前值下标
            int current = start;
            do{
                int next = (current + k)% nums.length;
                //值替换操作
                int tmp = nums[next];
                
                nums[next] = prev;
                prev =tmp;
                current = next;
                count ++;
                
            }while(start != current);
        }
    }
    
	//反转法
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    
    public void reverse(int[] nums,int start,int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}