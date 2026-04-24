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
    public int Count(ListNode head){
        ListNode temp = head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = Count(head);
        k = k%n;
        if(k==0) return head;
        int d = n - k;
        ListNode temp = head;
        for(int i=1;i<d;i++){
            temp = temp.next;
        }
        ListNode h2 = temp.next;
        temp.next = null;
        ListNode curr = h2;
        
        
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;

    return h2;
    }

}
