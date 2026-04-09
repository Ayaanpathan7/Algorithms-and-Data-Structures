class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        ListNode t1 = dummy;

        while (t1.next != null && t1.next.val < x) {
            temp = t1.next;
            t1 = t1.next;
        }

        while (t1.next != null) {
            if (t1.next.val < x) {
                ListNode t2 = t1.next;
                t1.next = t2.next;

                t2.next = temp.next;
                temp.next = t2;
                temp = temp.next;
            }
            else t1 = t1.next;
        }
        return dummy.next;
    }
}
