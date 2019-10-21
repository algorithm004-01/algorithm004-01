int maxArea(int* height, int heightSize){
#if 0
    /* 1. 暴力求解 */
    int i = 0;
    int j = 0;
    int max = 0;
    int area = 0;
    int h = 0;

    for (; i < heightSize; i++) {
        for (j = i + 1; j < heightSize; j++) {
            h = (height[i] < height[j] ? height[i] : height[j]);
            area = (j - i) * h;
            if (max < area)
                max = area;
        }
    }

    return max;
#else
    /* 双指针法 */
    /* 重点在于理解双指针的移动，每次都移动较短的指针 */

    int i = 0;
    int j = heightSize - 1;

    int max = 0;
    int area = 0;
    int h = 0;

    while (i < j) {
        h = (height[i] < height[j] ? height[i] : height[j]);
        area = (j - i) * h;
        if (max < area) max = area;
        //if (height[i] < height[j])
        //    i++;
        // else
        //    j--;
        while ((height[i] <= h) && i < j) i++;
        while ((height[j] <= h) && i < j) j--;
    }

    return max;
#endif
}
