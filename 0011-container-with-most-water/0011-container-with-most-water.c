#include <stdio.h>

int maxArea(int* height, int heightSize) {
    int left = 0;
    int right = heightSize - 1;
    int max_area = 0;

    while (left < right) {
        // Calculate the current area
        int width = right - left;
        int minHeight = height[left] < height[right] ? height[left] : height[right];
        int current_area = width * minHeight;

        // Update max_area if current_area is larger
        if (current_area > max_area) {
            max_area = current_area;
        }

        // Move the pointer pointing to the shorter line inward
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return max_area;
}


