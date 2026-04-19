class Solution {
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        ListNode secondhalf = reverse(slow.next);
        ListNode firsthalf = head;
        while(secondhalf!=null){
            if(firsthalf.val!=secondhalf.val) return false;
            secondhalf = secondhalf.next;
            firsthalf = firsthalf.next;
        }
    return true;
    }
}
