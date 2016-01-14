package Classone;

public class RemoveDuplicatesfromSortedList82 {
	public ListNode deleteDuplicates(ListNode head){
		if(head ==null|| head.next==null) return head;
		
		ListNode p = new ListNode(0);
		p.next = head;
		ListNode prev = p;
		ListNode curr = head;
		
		while(curr !=null){
			while(curr.next !=null && prev.next.val == curr.next.val){
				curr = curr.next;
			}
			if(prev.next == curr){
				prev = prev.next;
			}else{
				prev.next = curr.next;
			}
			curr = curr.next;
		}
		
		return p.next;
	}
}
