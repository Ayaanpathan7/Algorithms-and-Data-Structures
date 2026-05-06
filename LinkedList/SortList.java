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
    public ListNode findingMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid = findingMid(head);
        ListNode newMid = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(newMid);
        return mergeTwoLists(left,right);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(100);
        ListNode t = h;

        ListNode t1 = list1;
        ListNode t2 = list2;

        while (t1 != null && t2 != null) {
            ListNode m = min(t1, t2);
            t.next = m;
            t = m;

            if (m == t1) {
                t1 = t1.next;
            } else {
                t2 = t2.next;
            }
        }

        if (t1 != null) {
            t.next = t1;
        } else {
            t.next = t2;
        }

        return h.next;
    }

    public static ListNode min(ListNode a, ListNode b) {
        if (a.val < b.val)
            return a;
        else
            return b;
    }
}
