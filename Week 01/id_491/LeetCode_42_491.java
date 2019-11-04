class trappingRainWater {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        if (height == null || height.length <= 2) {
            return 0;
        } else {
            for (int i = 0; i < height.length; i++) {
                if (i == 0) {
                    stack.push(i);
                } else {
                    if (height[stack.peek()] <= height[i]) {
                        stack.push(i);
                    }
                }
            }

            int first = stack.pop();
            while (!stack.empty()) {
                int second = stack.pop();
                for (int i = second + 1; i <= first - 1; i++) {
                    sum += height[second] - height[i];
                }
                first = second;
            }

            for (int i = height.length - 1; i >= 0; i--) {
                if (i == height.length - 1) {
                    stack.push(i);
                } else {
                    if (height[stack.peek()] < height[i]) {
                        stack.push(i);
                    }
                }
            }

            first = stack.pop();
            while (!stack.empty()) {
                int second = stack.pop();
                for (int i = first + 1; i <= second - 1; i++) {
                    sum += height[second] - height[i];
                }
                first = second;
            }
        }

        return sum;
    }
}
