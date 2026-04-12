class Solution {
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
