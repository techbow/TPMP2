235. Lowest Common Ancestor of a Binary Search Tree

TEST CASE: {} p = null, q = null
                4  
              /   \
             2     6
            / \   / \
           1   3 5   7
           p = 1, q = 7
           p = 1, q = 3
           p = 7, q = 6



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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && q.val >= root.val) return root;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}