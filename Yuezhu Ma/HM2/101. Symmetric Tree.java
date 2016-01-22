101. Symmetric Tree

TEST CASE: {}
           {1, 2, 2}
           {1, 2, 2, 3, #, #, 3}

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricSub(root, root);
    }
    private boolean isSymmetricSub(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSymmetricSub(t1.left, t2.right) &&
               isSymmetricSub(t1.right, t2.left);
    }
}

