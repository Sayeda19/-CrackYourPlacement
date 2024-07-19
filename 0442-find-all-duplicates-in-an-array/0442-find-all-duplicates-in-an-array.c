
int* findDuplicates(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));
    if (!result) {
        *returnSize = 0;
        return NULL; // Return NULL if memory allocation fails
    }
    
    int* count = (int*)calloc(numsSize + 1, sizeof(int)); // Using numsSize+1 to handle nums[i] <= numsSize
    if (!count) {
        free(result);
        *returnSize = 0;
        return NULL; // Return NULL if memory allocation fails
    }
    
    int k = 0;
    for (int i = 0; i < numsSize; i++) {
        count[nums[i]]++;
        if (count[nums[i]] == 2) {
            result[k++] = nums[i];
        }
    }
    
    free(count);
    *returnSize = k;
    return result;
}
