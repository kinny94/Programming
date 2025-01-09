package questions.leetcode;

public class CopyListWithRandomPointers {

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public void copyList(Node head) {
        //
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node temp = new Node(curr.val);
            curr.next = temp;
            temp.next = next;
            curr = next;
        }
    }

    public void copyRandomPointer(Node head) {
        Node curr = head;
        while (curr != null) {
            Node random = curr.random;
            if (random != null) {
                curr.next.random = random.next;
            }
            curr = curr.next.next;
        }
    }

    public Node getCopy(Node head) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        Node curr = head;
        while (curr != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandomPointer(head);
        return getCopy(head);
    }
}
