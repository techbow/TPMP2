package tpmp;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null){
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }
    
    private boolean isSymmetricTree(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null && right !=null || right == null && left != null) return false;
        
        if(left.val == right.val){
            return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
        }else{
            return false;
        }
    }


}
