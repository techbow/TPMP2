package tpmp;

import java.util.ArrayList;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return true;
        ArrayList<Integer> inTraversalList = new ArrayList<Integer>();
        inTraversal(inTraversalList, root);
        
        for(int i = 1; i < inTraversalList.size(); i++){
            if (inTraversalList.get(i) <= inTraversalList.get(i-1)){
                return false;
            } 
        }
        return true;
    }
    
    private void inTraversal(ArrayList<Integer> inTraversalList, TreeNode root){
        if(root.left == null && root.right == null) {
            inTraversalList.add(root.val);
            return;
        }
        if(root.left != null){
            inTraversal(inTraversalList, root.left);
        }
        inTraversalList.add(root.val);
        if(root.right != null){
            inTraversal(inTraversalList, root.right);
        }
    }


}
