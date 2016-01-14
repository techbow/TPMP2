package Classone;

public class MergeTwoSortedLists21 {
	public ListNode mergeTwoList(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode l = new ListNode(0);
		ListNode l3 = l;
		 while(l1 != null && l2 != null){
			 if(l1.val < l2.val){
				 l3.next = l1;
				 l1 = l1.next;
			 }else{
				 l3.next = l2;
				 l2 = l2.next;
			 }
			 l3 = l3.next;
		 }
		 if(l1 !=null){
			 l3.next = l1;
		 }
		 if(l2 != null){
			 l3.next = l2;
		 }
		 return l.next;
	}
}
