class MyLinkedList {

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            if (temp == null) {
                return -1;
            }
            temp = temp.next;
        }

        if (temp == null) {
            return -1;
        }
        return temp.data;
    }

    public void addAtHead(int val) {
        Node temp = new Node(val);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public void addAtTail(int val) {
        Node temp = new Node(val);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size()) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size()) {
            addAtTail(val);
            return;
        }

        Node ptr = head;
        for (int i = 0; i < index - 1; i++) {
            if (ptr.next == null) {
                return;
            }
            ptr = ptr.next;
        }

        Node temp = new Node(val);
        temp.next = ptr.next;
        ptr.next = temp;
    }

    public int size() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;

            if (head == null) {
                tail = null;
            }
            return;
        }

        Node ptr = head;
        for (int i = 0; i < index - 1; i++) {
            if (ptr.next == null) {
                return;
            }
            ptr = ptr.next;
        }

        if (ptr.next == null) {
            return;
        }

        if (ptr.next == tail) {
            tail = ptr;
        }

        ptr.next = ptr.next.next;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
