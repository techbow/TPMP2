257. Binary Tree Paths

TAST CASE: {}
           {1}
           {1, 2, #, 3, 4, #, #, 5}


// using DFS
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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ret = new ArrayList<String>();
        pathDFS(root, "", ret);
        return ret;
    }
    private void pathDFS (TreeNode root, String solution, ArrayList<String> ret) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ret.add (solution + root.val);
        }
        pathDFS(root.left, solution + root.val + "->", ret);
        pathDFS(root.right, solution + root.val + "->", ret);
    }
}
