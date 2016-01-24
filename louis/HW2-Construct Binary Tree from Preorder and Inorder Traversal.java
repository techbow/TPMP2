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
        for (int i = start;i<= end;i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1 );
    }
    private TreeNode myBuild(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, root.val);
        root.left = myBuild(preorder, prestart+1, prestart + position - instart, inorder, instart, position - 1);
        root.right = myBuild(preorder, prestart + position - instart +1, preend, inorder, position + 1, inend);
        return root;
    }
}
