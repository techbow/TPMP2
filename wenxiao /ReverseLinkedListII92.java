package Classone;

public class ReverseLinkedListII92 {
	public ListNode reverseBetween(ListNode head, int m, int n){
		if(head ==null || head.next ==null) return head;
		
		ListNode p = new ListNode(0);
		p.next = head;
		ListNode prev = p;
		ListNode curr = null;
		ListNode next = null;
		
		for(int i = 0; i < n; i++){
			if(i < m - 1){
				prev = prev.next;
			}else if( i == m -1){
				curr = prev.next;
				next = curr.next;
			}else{
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
		}
		return p.next;
		
	}
}
