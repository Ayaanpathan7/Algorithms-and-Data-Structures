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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode temp = head;

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0); 

        ListNode temp_o = odd; 
        ListNode temp_e = even; 

        while (temp != null) {
            temp_o.next = temp;
            temp = temp.next;
            temp_o = temp_o.next;

            temp_e.next = temp;
            if(temp==null) break;
            temp = temp.next;
            temp_e = temp_e.next;


        }
        even = even.next;
        odd = odd.next;
        temp_o.next=even;
        return odd;
    }
}
