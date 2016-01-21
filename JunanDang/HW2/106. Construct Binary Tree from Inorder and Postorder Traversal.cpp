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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return helper(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() - 1);
    }
    
    TreeNode* helper(vector<int>& inorder, vector<int>& postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) return nullptr;
        
        int rootVal = postorder[postEnd];
        TreeNode *root = new TreeNode(rootVal);
        
        int i = inStart;
        while (inorder[i] != rootVal) {
            i++;
        }
        
        root->left = helper(inorder, postorder, inStart, i - 1, postStart, postStart + i - inStart - 1);
        root->right = helper(inorder, postorder, i + 1, inEnd, postStart + i - inStart, postEnd - 1);
        
        return root;
    }
};