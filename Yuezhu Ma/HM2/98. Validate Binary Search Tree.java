98. Validate Binary Search Tree

TEST CASE: {}
           {1}
           {1, 2, 3}
           {10, 7, 14, 6, 8, 12, 16, 5, #, #, 9, 11, 13, 15, 17}


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
        return isValidBSTSub (root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    public boolean isValidBSTSub (TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBSTSub(root.left, min, root.val)
            && isValidBSTSub(root.right, root.val, max);
    }
}