package questions.leetcode;

class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            Node nextLeftMost = null;
            Node prev = null;

            while (current != null) {

                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        nextLeftMost = current.left;
                    }
                    prev = current.left;
                }

                if (current.right != null) {
                    if (prev != null) {
                        prev.next = current.right;
                    } else {
                        nextLeftMost = current.right;
                    }
                    prev = current.right;
                }

                current = current.next;
            }
            leftMost  = nextLeftMost;
        }
        return root;
    }
}
