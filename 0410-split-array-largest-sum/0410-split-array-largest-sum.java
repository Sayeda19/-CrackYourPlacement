class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        
        // Find the range for binary search
        for (int num : nums) {
            left = Math.max(left, num); // Maximum single element
            right += num; // Sum of all elements
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid; // Try for a smaller maximum sum
            } else {
                left = mid + 1; // Increase the maximum sum
            }
        }
        
        return left; // Minimum possible largest sum
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int requiredSubarrays = 1; // At least one subarray is needed
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                // Start a new subarray
                requiredSubarrays++;
                currentSum = num;
                if (requiredSubarrays > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}
