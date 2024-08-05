// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int diameter = 0; // Variable to store the diameter of the tree

    public int diameterOfBinaryTree(TreeNode root) {
        // Start the DFS traversal
        depthFirstSearch(root);
        return diameter;
    }
    
    private int depthFirstSearch(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Recursively get the height of the left and right subtrees
        int leftHeight = depthFirstSearch(node.left);
        int rightHeight = depthFirstSearch(node.right);
        
        // Calculate the diameter at the current node
        diameter = Math.max(diameter, leftHeight + rightHeight);
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
