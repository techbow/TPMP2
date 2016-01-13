92. Reverse Linked List II

TEST CASE: NULL
           1->NULL m = 1, n = 1
           1->2->3->4->NULL m = 1, n = 2
           1->2->3->4->NULL m = 1, n = 3
           1->2->3->4->NULL m = 1, n = 4


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode start = dummy;
        ListNode l1 = null, l2 = null;
        
        for (int i = 0; i < n; i++) {
        	// find start point (1 position before m)
            if (i < m - 1 ) { 
                start = start.next;
            } 
            // init l1 and l2
            else if (i == m - 1) { 
                l1 = start.next;
                l2 = l1.next;
            } 
            else {
                l1.next = l2.next;
                l2.next = start.next;
                start.next = l2;
                l2 = l1.next;
            }
        }
        return dummy.next;
    }
}