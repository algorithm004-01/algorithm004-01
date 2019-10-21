#include <stdio.h>
#include <stdlib.h>

void printArray(int *nums, int numSize) {
    for (int i = 0; i < numSize; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}

int *twoSum(int* nums, int numsSize, int target, int *returnSize) {
    int *arr = malloc(sizeof(int) * 2);
    *returnSize = 0;
    for (int i = 0; i < numsSize - 1; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (target == nums[i] + nums[j]) {
                arr[0] = i;
                arr[1] = j;
                *returnSize += 2; 
                return arr;
            }
        }
    }
    return NULL;
}

int main(void) {
    int nums[] = { 3, 7, 11, 15 };
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int target = 9;
    int returnSize;
    int *arr = twoSum(nums, numsSize, target, &returnSize);
    printArray(nums, numsSize);
    printArray(arr, returnSize);
}