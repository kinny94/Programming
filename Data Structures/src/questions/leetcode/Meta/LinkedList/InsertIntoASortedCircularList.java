package questions.leetcode.Meta.LinkedList;

import questions.leetcode.Node;

public class InsertIntoASortedCircularList {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }


        Node node = head.next;
        Node prev = head;
        while (node != head) {

            if (prev.val <= insertVal && insertVal <= node.val) {
                break;
            }
            if (prev.val > node.val && (insertVal >= prev.val || insertVal <= node.val)) {
                break;
            }

            prev = node;
            node = node.next;
        }

        prev.next = newNode;
        newNode.next = node;
        return head;
    }

}
