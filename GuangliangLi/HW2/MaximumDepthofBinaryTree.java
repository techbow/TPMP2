package tpmp;

import java.util.ArrayList;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        ArrayList<Integer> lengthList = new ArrayList<Integer>();
        int[] length = new int[1];
        length[0] = 0;
        getLength(root, lengthList, length);
        int ret = 0;
        for(int i=0; i<lengthList.size(); i++){
            ret = Math.max(ret,lengthList.get(i));
        }
        return ret;
    }
    
    private void getLength(TreeNode root, ArrayList<Integer> lengthList, int[] length){
        if(root == null) return;
        length[0] = length[0] + 1;
        if(root.left == null && root.right == null){
            lengthList.add(length[0]);
        }else{
            getLength(root.left, lengthList, length);
            getLength(root.right, lengthList, length);
        }
            length[0] = length[0] - 1;
    }
}
