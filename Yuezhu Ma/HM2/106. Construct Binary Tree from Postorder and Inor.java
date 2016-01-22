106. Construct Binary Tree from Postorder and Inorder Traversal

TEST CASE: {}
               1
              / \
             2   3
            / \   \
           4   5   6
           post: 4 5 2 6 3 (1) ---> left: in中找到根1后左边长度为左子树：4 5（2）   right: 同理 6（3） 
           in  : 4 2 5 (1) 3 6 ---> left: 根左边的: 4 (2) 5  right: 根右边的 （3）6  根的确定看post最后一位


public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
}

    public TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd){
     if(inStart > inEnd || postStart > postEnd){
         return null;
    }

    int rootVal = post[postEnd];
    int rootIndex = 0;
    for(int i = inStart; i <= inEnd; i++){ // find root index
         if(in[i] == rootVal){
             rootIndex = i;
             break;
         }
     }
   
    int len = rootIndex - inStart;
    TreeNode root = new TreeNode(rootVal); //generate new root
    root.left = buildTree(in, inStart, rootIndex-1, post, postStart, postStart+len-1); // recurisive left subtree
    root.right = buildTree(in, rootIndex+1, inEnd, post, postStart+len, postEnd-1); // recurisive right subtree
   
    return root;
 }