package tpmp;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        
        TreeNode root = new TreeNode(nums[nums.length/2]);
        if(nums.length == 1) return root;
        int[] leftSubNums = getSubNums(nums, true);
        int[] rightSubNums = getSubNums(nums, false);
        root.left = sortedArrayToBST(leftSubNums);
        root.right = sortedArrayToBST(rightSubNums);
        return root;
    }
    
    private int[] getSubNums(int[] nums, boolean leftFlag){
        int[] ret = new int[nums.length/2];;
        if(leftFlag){
            System.arraycopy(nums, 0, ret, 0, nums.length/2);
        }else{
            if(nums.length%2 == 0){
                ret = new int[nums.length/2 -1];
                System.arraycopy(nums, nums.length/2 + 1, ret, 0, nums.length/2 -1);
            }else{
                System.arraycopy(nums, nums.length/2 + 1, ret, 0, nums.length/2);
            }
        
        }
        return ret;
    }


}
