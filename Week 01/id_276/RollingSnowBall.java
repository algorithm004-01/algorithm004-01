public class RollingSnowBall {
    //move the zero to the tail of the array
    //and keep the order of the Non-zeros
    //1.new one array
    public void rollingSnowBall(int[] snowBalls){
        int[] temp = new int[snowBalls.length];
        int tail = snowBalls.length;
        int head = 0;

        for (int i=0;i<snowBalls.length&&tail!=head;i++) {
            if(snowBalls[i] != 0){
                snowBalls[head++] = snowBalls[i];
            }
            else{
                snowBalls[--tail] = 0;
            }
        }
    }

    //2.store the Non-zeros

    public void moveZeros(int[] nums) {
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)cnt++;
            else{
                nums[i-cnt] = nums[i];
            }
        }

        for(int i=nums.length-cnt;i<nums.length;i++) {
            nums[i] = 0;
        }
    }

    //3.the mehthod  is same as 2
    public void moveZeros(int[] nums) {
        int insertPos = 0;
        for(int i:nums) {
            if(i!=0)nums[insertPos++] = i;
        }
        for(int i=insertPos;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    //4.the method is same as 2

    public void rollingBalls(int[] balls){
        int snowballSize = 0;
        for(int i=0;i<balls.length;i++){
            if(balls[i] == 0)snowballSize++;
            else if(snowballSize > 0){
                balls[i-snowballSize] = balls[i];
                balls[i] = 0;
            }
        }
    }
}
