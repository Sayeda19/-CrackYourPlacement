import java.util.*;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // Priority queue to store (y_i - x_i) values
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int maxValue = Integer.MIN_VALUE;

        for (int[] point : points) {
            int x_j = point[0];
            int y_j = point[1];

            // Remove elements from the heap where the difference in x is greater than k
            while (!maxHeap.isEmpty() && x_j - maxHeap.peek()[0] > k) {
                maxHeap.poll();
            }

            // Compute the maximum value using the top of the heap
            if (!maxHeap.isEmpty()) {
                maxValue = Math.max(maxValue, y_j + x_j + maxHeap.peek()[1]);
            }

            // Add the current point to the heap
            maxHeap.offer(new int[]{x_j, y_j - x_j});
        }

        return maxValue;
    }
}
