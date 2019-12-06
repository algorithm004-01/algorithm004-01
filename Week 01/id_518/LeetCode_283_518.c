#include <stdio.h>

void printArray(int *nums, int numSize) {
    for (int i = 0; i < numSize; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}


void moveZeroes(int *nums, int numsSize) {
    int j = 0;   
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != 0) {
            nums[j] = nums[i];
            if (i != j) {          // i must be larger or equal to j      
                nums[i] = 0;
            }
            j++;
        }
    }
    printArray(nums, numsSize);
}

/**
 *  input  [0,1,0,3,12]
 *  output [1,3,12,0,0]     
 **/

int main(void) {
    int input[] = { 0, 1, 0, 3, 12 };
    int length = sizeof(input)/sizeof(input[0]); 
    printArray(input, length);
    moveZeroes(input, length);
}

