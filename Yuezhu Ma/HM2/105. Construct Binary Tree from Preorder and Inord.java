105. Construct Binary Tree from Preorder and Inorder Traversal

TEST CASE: {}
               1
              / \
             2   3
            / \   \
           4   5   6
           pre: (1) 2 4 5 3 6 ---> left: in中找到根1后, 左边长度为左子树：(2) 4 5   right: 同理 (3）6 
           in : 4 2 5 (1) 3 6 ---> left: 根左边的: 4 (2) 5  right: 根右边的 （3）6  根的确定看pre的第一位
 

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeSub(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTreeSub(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {  // find root index in inorder
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;   // caculate the length of left subtree
        TreeNode root = new TreeNode(rootVal);  // generate root node
        root.left = buildTreeSub(preorder, preStart + 1, preStart + len, inorder, inStart, rootIndex - 1);  // recrusive left subtree
        root.right = buildTreeSub(preorder, preStart + len + 1, preEnd, inorder, rootIndex + 1, inEnd);  // recrusive right subtree
        return root;
    }
}