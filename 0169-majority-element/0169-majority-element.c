

int majorityElement(int* nums, int numsSize) {
    int count = 0;
    int candidate = 0;

    // Find the candidate using Boyer-Moore Voting Algorithm
    for (int i = 0; i < numsSize; i++) {
        if (count == 0) {
            candidate = nums[i];
        }
        count += (nums[i] == candidate) ? 1 : -1;
    }

    // Verify if the candidate is indeed the majority element
    count = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == candidate) {
            count++;
        }
    }

    if (count > numsSize / 2) {
        return candidate;
    } else {
        // Return an appropriate value or handle error as per requirements
        return -1; // Assuming input always has a majority element, this can be an error value
    }
}
