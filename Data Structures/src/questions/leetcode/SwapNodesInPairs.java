package questions.leetcode;

public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next != null) {
                int temp = curr.val;
                curr.val = curr.next.val;
                curr.next.val = temp;
            }
            curr = curr.next.next;
        }
        return head;
    }
}
