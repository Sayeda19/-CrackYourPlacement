import java.util.*;

class RandomizedCollection {

    private List<Integer> values;  // Stores the values
    private Map<Integer, Set<Integer>> indices;  // Maps values to indices in the values list
    private Random random;  // For generating random numbers

    public RandomizedCollection() {
        values = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !indices.containsKey(val);
        if (notPresent) {
            indices.put(val, new HashSet<>());
        }
        
        indices.get(val).add(values.size());
        values.add(val);
        return notPresent;
    }
    
    public boolean remove(int val) {
        if (!indices.containsKey(val) || indices.get(val).isEmpty()) {
            return false;
        }
        
        // Get an index to remove
        int indexToRemove = indices.get(val).iterator().next();
        indices.get(val).remove(indexToRemove);
        
        // Swap with the last element if necessary
        if (indexToRemove < values.size() - 1) {
            int lastElement = values.get(values.size() - 1);
            values.set(indexToRemove, lastElement);
            indices.get(lastElement).remove(values.size() - 1);
            indices.get(lastElement).add(indexToRemove);
        }
        
        // Remove the last element
        values.remove(values.size() - 1);
        
        // Clean up if needed
        if (indices.get(val).isEmpty()) {
            indices.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
