package questions.leetcode.Meta.Trees;

public class LowestCommonAncestor3 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Node pointer1 = p;
        Node pointer2 = q;
        while(pointer1 != pointer2) {
            if (pointer1.parent != null) {
                pointer1 = pointer1.parent;
            } else {
                pointer1 = q;
            }

            if (pointer2.parent != null) {
                pointer2 = pointer2.parent;
            } else {
                pointer2 = p;
            }
        }
        return pointer1;
    }
}
