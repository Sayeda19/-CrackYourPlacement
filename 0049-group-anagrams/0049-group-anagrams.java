import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to hold the sorted string as key and list of anagrams as value
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        // Iterate through each string in the input array
        for (String str : strs) {
            // Convert the string to a character array, sort it and then convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // If the sorted string is not already a key in the map, add it with a new list
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            
            // Add the original string to the list corresponding to the sorted key
            anagramMap.get(sortedStr).add(str);
        }
        
        // Return the values of the map as a list of lists
        return new ArrayList<>(anagramMap.values());
    }
}
