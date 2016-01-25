package tpmp;

public class ConstructBinaryTreeFromInPost {
    
    public TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int position = getPosition(postorder[postorder.length-1], inorder);
        int[] leftInOrder = getSubOrder(inorder, position, true, true);
        int[] rightInOrder = getSubOrder(inorder, position, false, true);
        int[] leftPostOrder = getSubOrder(postorder, position, true, false);
        int[] rightPostOrder = getSubOrder(postorder, position, false, false);
        root.left = buildTree(leftInOrder, leftPostOrder);
        root.right = buildTree(rightInOrder, rightPostOrder);
        return root;
    }
    
    private int getPosition(int target, int[] targetArr){
        for(int i = 0; i < targetArr.length; i++){
            if(target == targetArr[i]){
                return i;
            }
        }
        return 0;
    }
    
    private int[] getSubOrder(int[] orderArr, int position, boolean LeftFlag, boolean InFlag){
        int[] retArr;
        if(LeftFlag){
            retArr = new int[position];
            System.arraycopy(orderArr, 0, retArr, 0, position);
        }else{
            if(InFlag){
                retArr = new int[orderArr.length - position - 1];
                System.arraycopy(orderArr, position + 1, retArr, 0, orderArr.length - position - 1);
            }else{
                retArr = new int[orderArr.length - position - 1];
                System.arraycopy(orderArr, position, retArr, 0, orderArr.length - position - 1);
            }
        }
        return retArr;
    }
    


}
