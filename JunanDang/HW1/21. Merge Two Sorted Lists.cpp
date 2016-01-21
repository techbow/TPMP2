 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode dummy(0);
        ListNode *prev = &dummy;
        while (l1 && l2) {
            if (l1->val < l2->val) {
                prev->next = l1;
                prev = l1;
                l1 = l1->next;
            } else {
                prev->next = l2;
                prev = l2;
                l2 = l2->next;
            }
        }
        if (l1) {
            prev->next = l1;
        } else {
            prev->next = l2;
        }
        return dummy.next;
    }
};
