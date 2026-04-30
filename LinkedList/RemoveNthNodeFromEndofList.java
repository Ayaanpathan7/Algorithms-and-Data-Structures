/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        if(head.next==null) return null;

        ListNode temp = head;
        int count=0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        if (n == count) {
            return head.next;
        }
        int k=count-n-1;
        ListNode t2 = head;
        for(int i=1;i<=k;i++){
            t2=t2.next;
        }
        t2.next=t2.next.next;
    return head;
    }
}
