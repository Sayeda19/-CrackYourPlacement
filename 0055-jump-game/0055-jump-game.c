#include <stdio.h>
#include <stdbool.h>

bool canJump(int* nums, int numsSize) {
    int farthest = 0;

    for (int i = 0; i < numsSize; i++) {
        if (i > farthest) {
            return false; // If we can't reach the current index, return false
        }
        farthest = farthest > (i + nums[i]) ? farthest : (i + nums[i]);
        if (farthest >= numsSize - 1) {
            return true; // If we can reach or exceed the last index, return true
        }
    }

    return false; // If we finish the loop without reaching the last index, return false
}
