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
        if ( head == null ) {
            return head;
        }
        
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        head = fakehead;
        
        for ( int i = 1; i < m; i++ ) {
            head = head.next;
        }
        
        ListNode beforen = head;
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode aftern = head.next.next;
        for ( int i = m; i < n; i++ ) {
            ListNode t = aftern.next;
            aftern.next = nNode;
            nNode = aftern;
            aftern = t;
        }
        beforen.next = nNode;
        mNode.next = aftern;
        return fakehead.next;
    }
}
