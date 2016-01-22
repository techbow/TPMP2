/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    private boolean helper(TreeNode root, double min, double max) {
        if (root == null) {
            return true;
        }
        if (min < root.val && root.val < max) {
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        } else return false;
        
    }
}
