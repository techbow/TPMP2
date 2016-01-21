/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return helper(inorder, preorder, 0, inorder.size() - 1, 0, preorder.size() - 1);
    }
    
    TreeNode* helper(vector<int>& inorder, vector<int>& preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd) return nullptr;
        
        int rootVal = preorder[preStart];
        TreeNode *root = new TreeNode(rootVal);
        
        int i = inStart;
        while (inorder[i] != rootVal) {
            i++;
        }
        
        root->left = helper(inorder, preorder, inStart, i - 1, preStart + 1, preStart + i - inStart);
        root->right = helper(inorder, preorder, i + 1, inEnd, preStart + i - inStart + 1, preEnd);
        
        return root;
    }
};