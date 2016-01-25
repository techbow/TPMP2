package tpmp;

public class ReverseLinkedList92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = new ListNode(0);
        p = head;
        int length = 0;
        while(p != null){
            length++;
            p = p.next;
        }
        if (length <= 1) return head;
        ListNode preNode = new ListNode(0);
        preNode = dummyHead;
        ListNode curNode = new ListNode(0);
        ListNode nextNode = new ListNode(0);
        ListNode mNode = new ListNode(0);
        for(int i = 1; i <= n; i++){
            if(i < m){
                preNode = preNode.next;
            }else if(i == m){
                mNode = preNode.next;
                curNode = mNode.next;
            }else if(i>m){
                nextNode = curNode.next;
                curNode.next = preNode.next;
                preNode.next = curNode;
                mNode.next = nextNode;
                curNode = nextNode;
            }
        }
        return dummyHead.next;
    }
}
