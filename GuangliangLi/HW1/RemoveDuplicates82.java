/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = dummyHead;
		while(p.next != null && p.next.next != null){
			if (p.next.val == p.next.next.val){
			    int dup = p.next.val;
				while (p.next != null && p.next.val == dup){
					p.next = p.next.next;
				}
			}else{
			    p = p.next;
			}
		}
		return dummyHead.next;
    }
}