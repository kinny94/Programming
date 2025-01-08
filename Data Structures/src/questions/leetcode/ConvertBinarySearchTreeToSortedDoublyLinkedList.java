package questions.leetcode;

import java.util.Deque;
import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    public Node getRightMostNode(Node node, Node curr) {
        while(node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
    }

    /*
        keep connecting the last node and curr node.
        then connect the first node and last node.
        O(N) space
    */
    public Node treeToDoublyListNotOptimized(Node root) {
        if (root == null) {
            return null;
        }

        Node first = null;
        Node last = null;

        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null) {
                first = root;
            }
            if (last != null) {
                last.right = root;
                root.left = last;
            }
            last = root;
            root = root.right;
        }
        first.left = last;
        last.right = first;
        return first;
    }

    // Morris Traversal - O(1) space
    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }

        Node dummy = new Node(-1);
        Node prev = dummy;
        Node curr = root;

        while (curr != null) {
            Node left = curr.left;
            if (left == null) {
                // create links
                prev.right = curr;
                curr.left = prev;
                prev = curr;

                //move
                curr = curr.right;
            } else {
                Node rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    // create thread
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    // delete thread
                    rightMostNode.right = null;

                    // create links
                    prev.right = curr;
                    curr.left = prev;
                    prev = curr;

                    // move
                    curr = curr.right;
                }
            }
        }
        Node head = dummy.right;
        dummy.right = null;
        head.left = null;
        prev.right = head;
        head.left = prev;
        return head;
    }

}
