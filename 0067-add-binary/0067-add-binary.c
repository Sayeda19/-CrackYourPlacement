#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to add two binary strings
char* addBinary(char* a, char* b) {
    int lenA = strlen(a);
    int lenB = strlen(b);
    int maxLen = (lenA > lenB) ? lenA : lenB;

    // Allocate memory for the result, +1 for possible carry and +1 for null terminator
    char* result = (char*)malloc((maxLen + 2) * sizeof(char));
    if (result == NULL) {
        return NULL; // Memory allocation failed
    }

    // Initialize the result string and carry
    result[maxLen + 1] = '\0';
    int carry = 0;
    int i, j, k;

    // Traverse the strings from right to left
    for (i = lenA - 1, j = lenB - 1, k = maxLen; i >= 0 || j >= 0; i--, j--, k--) {
        int bitA = (i >= 0) ? a[i] - '0' : 0;
        int bitB = (j >= 0) ? b[j] - '0' : 0;
        int sum = bitA + bitB + carry;

        // Set the result bit and update carry
        result[k] = (sum % 2) + '0';
        carry = sum / 2;
    }

    // If there is a carry left, set it as the most significant bit
    if (carry) {
        result[k] = carry + '0';
    } else {
        // Shift result to the left if there's no carry
        memmove(result, result + 1, maxLen + 1);
    }

    return result;
}


