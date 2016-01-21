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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode *LCA = root;
        while (true) {
            if (LCA->val > p->val && LCA->val > q->val) {
                LCA = LCA->left;
            } else if (LCA->val < p->val && LCA->val < q->val) {
                LCA = LCA->right;
            } else {
                return LCA;
            }
        }
    }
};