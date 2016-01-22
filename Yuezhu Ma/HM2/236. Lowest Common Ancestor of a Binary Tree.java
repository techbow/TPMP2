236. Lowest Common Ancestor of a Binary Tree

TEST CASE: {}
           {1} p = 1; q = 1
           {1, 2, 3, 4, 5, 6, 7} p = 2 q = 5
           {1, 2, 3, 4, 5, 6, 7} p = 2 q = 3
           {1, 2, 3, 4, 5, 6, 7} p = 3 q = 8



/*
  SOLUTION 1: RECURISIVE + 二治法
*/
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
        if (root == null) return null;
        if (root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}



/*
  SOLUTION 2: 假设有指针指向parent， 就可以转换成两个linkedlist merge
*/


