 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode dummy(0);
        dummy.next = head;
        
        ListNode *prev = &dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev->next;
        }
        ListNode *curr = prev->next;
        
        for (int i = 0; i < n - m; i++) {
            ListNode *temp = curr->next;
            curr->next = temp->next;
            temp->next = prev->next;
            prev->next = temp;
        }
        
        return dummy.next;
    }
};
