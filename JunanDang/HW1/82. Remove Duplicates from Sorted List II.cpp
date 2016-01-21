 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode dummy(0);
        dummy.next = head;
        
        ListNode *curr = head, *pos = &dummy;
        
        while (curr && curr->next) {
            if (curr->val == curr->next->val) {
                while (curr->next && curr->val == curr->next->val) {
                    curr = curr->next;
                }
                curr = curr->next;
                pos->next = curr;
            }
            else {
                pos = pos->next;
                curr = curr->next;
            }
        }
        
        return dummy.next;
    }
};
