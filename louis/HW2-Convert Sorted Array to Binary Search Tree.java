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
        if (nums == null) {
            return null;
        };
        return convert(nums, 0, nums.length-1);
    }
    public TreeNode convert(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode mid = new TreeNode(nums[start + (end-start)/2]);
        mid.left = convert(nums, start, start + (end-start)/2 - 1);
        mid.right = convert(nums, start + (end-start)/2 +1, end);
        return mid;
    }
}
