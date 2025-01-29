package questions.leetcode.Meta.LinkedList;

import questions.leetcode.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {


    Node first = null;
    Node last = null;

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }

        solve(root);

        last.right = first;
        first.left = last;
        return first;
    }

    public void solve(Node node) {
        if (node != null) {
            // left
            solve(node.left);

            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }
            else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;

            // right
            solve(node.right);
        }
    }

    public Node getRightMostNode(Node node, Node curr) {
        while(node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
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
