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
    bool isValidBST(TreeNode* root) {
        return validBSThelper(root, nullptr, nullptr);
    }
    
    bool validBSThelper(TreeNode* root, TreeNode* minnode, TreeNode* maxnode) {
        if (root == nullptr) {
            return true;
        }
        
        bool left = validBSThelper(root->left, minnode, root);
        if (!left) return false;
        bool right = validBSThelper(root->right, root, maxnode);
        if (!right) return false;
        
        if (minnode && minnode->val >= root->val || maxnode && maxnode->val <= root->val) {
            return false;
        } else {
            return true;
        }
    }
};