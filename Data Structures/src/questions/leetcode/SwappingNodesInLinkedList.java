package questions.leetcode;

public class SwappingNodesInLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int count = 0;
        ListNode curr = head;
        ListNode front = null;
        ListNode end = null;

        while (curr != null) {
            count++;
            if (end != null) {
                end = end.next;
            }
            if (count == k) {
                front = curr;
                end = head;
            }



            curr = curr.next;
        }
        swap(front, end);
        return head;
    }

    private void swap(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
