package tpmp;

public class LowestCommonAncestor {
    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode leftLCA = findLowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = findLowestCommonAncestor(root.right, p, q);
        if(leftLCA != null && rightLCA != null){
            return root;
        }else if(leftLCA != null){
            return leftLCA;
        }else{
            return rightLCA;
        }
    }
}
