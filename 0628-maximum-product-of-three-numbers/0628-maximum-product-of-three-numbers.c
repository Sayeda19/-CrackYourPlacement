int compareDesc(const void* a, const void* b) {
    return (*(int*)b - *(int*)a);
}
int maximumProduct(int* nums, int numsSize) {
    // Sort the array in descending order
    qsort(nums, numsSize, sizeof(int), compareDesc);

    // Calculate the product of the three largest numbers
    int product1 = nums[0] * nums[1] * nums[2];

    // Calculate the product of the two smallest numbers and the largest number
    int product2 = nums[0] * nums[numsSize - 2] * nums[numsSize - 1];

    // Return the maximum of the two products
    return (product1 > product2) ? product1 : product2;
}