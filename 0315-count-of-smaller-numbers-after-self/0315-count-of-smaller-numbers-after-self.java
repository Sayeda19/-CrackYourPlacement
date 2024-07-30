import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Solution {

    class BIT {
        int[] bit;
        int size;

        BIT(int size) {
            this.size = size;
            this.bit = new int[size + 1];
        }

        void update(int index, int value) {
            while (index <= size) {
                bit[index] += value;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> ranks = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            if (!ranks.containsKey(sorted[i])) {
                ranks.put(sorted[i], i + 1); // 1-based index for BIT
            }
        }

        // BIT/Fenwick Tree array
        BIT bit = new BIT(sorted.length);

        // Process the array in reverse
        for (int i = n - 1; i >= 0; i--) {
            int rank = ranks.get(nums[i]);
            result.add(0, bit.query(rank - 1)); // Count of numbers less than nums[i]
            bit.update(rank, 1); // Add nums[i] to BIT
        }

        return result;
    }
}
