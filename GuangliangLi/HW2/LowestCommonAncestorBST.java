package tpmp;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode r = new TreeNode(0);
            r = p;
            p = q;
            q = r;
        }
        if(root.val >= p.val && root.val <= q.val){
            return root;
        }else if(root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
