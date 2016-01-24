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
    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    private TreeNode helper(int[] inorder, int instart, int inend,
            int[] postorder, int poststart, int postend) {
        if (instart > inend)  return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int position = findPosition(inorder, instart, inend, root.val);
        root.left = helper(inorder, instart, position - 1, postorder, poststart, poststart + position - instart - 1);
        root.right = helper(inorder, position + 1, inend, postorder, poststart + position - instart, postend - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

}
