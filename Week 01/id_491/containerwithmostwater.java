class containerwithmostwater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int lengthFromBegin = 0;
            for (int j = 0; j < i; j++) {
                if (height[i] <= height[j]) {
                    lengthFromBegin = i - j;
                    break;
                }
            }

            int lengthFromEnd = 0;
            for (int j = height.length - 1; j > i + lengthFromBegin; j--) {
                if (height[i] <= height[j]) {
                    lengthFromEnd = j - i;
                    break;
                }
            }

            maxArea = Math.max(maxArea, height[i] * Math.max(lengthFromBegin, lengthFromEnd));
        }
        return maxArea;
    }
}
