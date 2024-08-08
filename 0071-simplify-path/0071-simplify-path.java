import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Ignore empty parts and current directory references
                continue;
            }
            if (component.equals("..")) {
                // Move up one level if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Add valid directory name to stack
                stack.push(component);
            }
        }
        
        // Build the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }
        
        // If the path is empty, return root directory "/"
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }
}
