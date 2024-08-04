import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack = new Stack<>();
    private Integer nextInteger = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize the stack with the top-level list's iterator
        stack.push(nestedList.iterator());
        advanceToNextInteger();
    }

    @Override
    public Integer next() {
        // Ensure nextInteger is set before calling next()
        if (nextInteger == null) {
            throw new NoSuchElementException();
        }
        
        // Store the current nextInteger and advance to the next
        Integer result = nextInteger;
        advanceToNextInteger();
        return result;
    }

    @Override
    public boolean hasNext() {
        // Check if there's a next integer
        return nextInteger != null;
    }

    private void advanceToNextInteger() {
        nextInteger = null;
        
        // Process the stack until we find the next integer or the stack is empty
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> currentIterator = stack.peek();
            
            // If the iterator is exhausted, pop it from the stack
            if (!currentIterator.hasNext()) {
                stack.pop();
                continue;
            }
            
            NestedInteger current = currentIterator.next();
            
            if (current.isInteger()) {
                // Found an integer, set it to nextInteger
                nextInteger = current.getInteger();
                return;
            } else {
                // Push the nested list's iterator onto the stack
                stack.push(current.getList().iterator());
            }
        }
    }
}
