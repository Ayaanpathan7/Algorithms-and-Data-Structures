/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node temp = head;
        while(temp!=null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        temp =head;
        while(temp!=null){
            Node copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
        Node dummy = new Node(-1);
        Node copyHead = dummy;
        Node temp2 = head;

        while(temp2!=null){
            dummy.next = temp2.next;
            temp2.next = temp2.next.next;
            dummy = dummy.next;
            temp2 = temp2.next;
        }
        return copyHead.next;
    }
}
