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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = head;
        ListNode p = head;
        int count=0;
        if(t==null || t.next==null) return head;
        while(p!=null){
            if(t.val==p.val){
                p=p.next;
                count++;
            }
            else{
                if(count<=1){
                    t=t.next;
                }
                else{
                t.next = p;
                t=p;
                count = 0;
                }
            }
        }  
        if (count > 1) {
            t.next = p;
        }  
    return head;    
    }
}
