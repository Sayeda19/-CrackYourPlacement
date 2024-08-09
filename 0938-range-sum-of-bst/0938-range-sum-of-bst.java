class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        
        // If current node's value is within the range [low, high], include it in the sum
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        
        // If current node's value is greater than low, there might be nodes in the left subtree within range
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        
        // If current node's value is less than high, there might be nodes in the right subtree within range
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        
        return sum;
    }
}
