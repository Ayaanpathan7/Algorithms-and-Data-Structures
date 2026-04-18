class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode prevNode=head;
        ListNode currentNode=head.next;
        while(currentNode!=null){
            ListNode nextNode=currentNode.next;
            currentNode.next=prevNode;

            //update
            prevNode=currentNode;
            currentNode=nextNode;


        }
        head.next=null;
        return prevNode;
    }
}
