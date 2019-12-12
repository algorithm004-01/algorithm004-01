package linkedlist;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

public class TrapWaters {
    public int trap(int[] arr) {
        int left=0,right=arr.length-1;
        int maxLeft=0,maxRight=0;
        int sum = 0;
        while (left < right){
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    sum += maxLeft- height[left];
                }
                ++left;
            } else {
                if (height[right] < maxRight) {
                    maxRight = height[right];
                } else {
                    sum += maxRight-height[right];
                }
                --right;
            }
        }

        return sum;
    }
}
