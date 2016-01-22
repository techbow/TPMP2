108. Convert Sorted Array to Binary Search Tree

TEST CASE: []
           [1]
           [1, 2]
           [1, 2, 3]
           [1, 2, 3, 4, 5, 6, 7]



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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return sortedArrayToBSTSub(nums, 0, nums.length - 1);
        
        
    }
    private TreeNode sortedArrayToBSTSub(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode tn = new TreeNode(nums[mid]);
        tn.left = sortedArrayToBSTSub(nums, start, mid - 1);
        tn.right = sortedArrayToBSTSub(nums, mid + 1, end);
        return tn;
    }
}


