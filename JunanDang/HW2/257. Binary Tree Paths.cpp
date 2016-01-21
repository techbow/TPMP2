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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        if (root == nullptr) return result;
        
        vector<int> path;
        helper(root, path, result);
        return result;
    }
    
    string genPath(vector<int>& path) {
        stringstream ss;
        for (int num : path) {
            ss << num << "->";
        }
        
        string str(ss.str());
        str.pop_back();
        str.pop_back();
        return str;
    }
    
    void helper(TreeNode* root, vector<int>& path, vector<string>& result) {
        path.push_back(root->val);
        
        if (root->left == nullptr && root->right == nullptr) {
            result.push_back(genPath(path));
        }
        
        if (root->left)
            helper(root->left, path, result);
        if (root->right)
            helper(root->right, path, result);
        
        path.pop_back();
    }
};