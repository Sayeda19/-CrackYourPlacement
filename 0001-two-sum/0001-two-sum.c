#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    // Allocate memory for the result
    int* result = (int*)malloc(2 * sizeof(int));
    
    // Check if memory allocation was successful
    if (!result) {
        *returnSize = 0;
        return NULL;
    }

    // Initialize returnSize to 2 because we are returning two indices
    *returnSize = 2;

    // Iterate over the array to find the two indices
    for (int i = 0; i < numsSize - 1; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }

    // If no solution is found, free the allocated memory and set returnSize to 0
    free(result);
    *returnSize = 0;
    return NULL;
}
