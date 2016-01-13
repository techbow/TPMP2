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
        if( head == null )
            return head;
        
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        // starts from beginning
        head = fakehead;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int temp = head.next.val;
                while (head.next != null && head.next.val == temp) {
                    head.next = head.next.next;
                }            
            } else {
                head = head.next;
            }
        }
        return fakehead.next;
    }
}
