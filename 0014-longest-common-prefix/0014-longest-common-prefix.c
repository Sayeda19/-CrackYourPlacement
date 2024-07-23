#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Comparator function for sorting the strings
int compare(const void *a, const void *b) {
    return strcmp(*(const char **)a, *(const char **)b);
}

char * longestCommonPrefix(char **strs, int strsSize) {
    if (strsSize == 0) return "";
    if (strsSize == 1) return strs[0];
    
    // Sort the array of strings
    qsort(strs, strsSize, sizeof(char *), compare);
    
    // Find the common prefix between the first and last string in the sorted array
    char *first = strs[0];
    char *last = strs[strsSize - 1];
    int i = 0;
    while (first[i] && first[i] == last[i]) {
        i++;
    }
    
    // Create a new string for the prefix and return it
    char *prefix = (char *)malloc((i + 1) * sizeof(char));
    strncpy(prefix, first, i);
    prefix[i] = '\0';
    return prefix;
}

