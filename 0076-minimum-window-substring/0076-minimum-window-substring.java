import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for characters in t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Frequency map for characters in the current window
        Map<Character, Integer> windowFreq = new HashMap<>();
        int required = tFreq.size();
        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        String minWindow = "";

        while (right < s.length()) {
            // Add character from right to window
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if the current character helps in forming the valid window
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window until it is invalid
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the result if this window is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minWindow = s.substring(left, right + 1);
                }

                // Remove character from left of window
                windowFreq.put(c, windowFreq.get(c) - 1);
                if (tFreq.containsKey(c) && windowFreq.get(c).intValue() < tFreq.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minWindow;
    }
}
