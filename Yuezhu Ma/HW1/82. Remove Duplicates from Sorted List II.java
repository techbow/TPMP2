82. Remove Duplicates from Sorted List II

TEST CASE: NULL
           1->NULL
           1->2->3->NULL
           1->2->2->3->NULL
           1->1->2->3->NULL
           1->2->3->3->NULL
           1->1->2->2->NULL


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // no duplicates case
        if (head == null || head.next == null) return head;
        
        // avoid head was deleted
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // 3 points: pre, current, post and check if dup
        ListNode pre = dummy, cur = head, post = head.next;
        boolean duplicate = false;
        
        while (post != null) {
            if (cur.val == post.val) {
                duplicate = true;
                post = post.next;
                if (post == null) {
                    pre.next = null;
                }
            } else {
                if (duplicate) {
                    pre.next = post;
                    duplicate = false;
                } else {
                    pre = cur;
                }
                cur = post;
                post = post.next;
            }
        }
        return dummy.next;
    }
}
