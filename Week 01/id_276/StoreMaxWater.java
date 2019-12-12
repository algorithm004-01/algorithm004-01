public class StoreMaxWater {
    public int maxWater(int[] height) {
        int waters = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++) {
                waters = Math.max(waters,Math.min(height[i],heightj)*(j-1));
            }
        }
        return waters;
    }
    public int maxWater(int[] height, int i) {
        int waters = 0;
        int l=0,r=height.length-1;
        while (l < r) {
            waters = Math.max(waters,Math.min(height[l],height[r])*(r-l));
            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return waters;
    }
    //1
    public int maxWaters(int[] height) {
        int waters = 0;
        int l=0,r=height.length-1;
        while (l < r) {
            int h = Math.min(height[l],height[r]);
            waters = Math.max(waters,h*(r-l));

            while (height[l]<=h&&l<r)l++;
            while (height[r]<=h&&l<r)r--;
        }
        return waters;
    }

}
