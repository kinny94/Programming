package questions.leetcode;

public class SplitLinkedListInKParts {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int size = 0;
        ListNode current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        int split = size / k;
        int remaining = size % k;

        current = head;
        ListNode prev = null;

        for (int i=0; i<k; i++) {
            ans[i] = current;
            int currentRemaining = remaining > 0 ?  1: 0;
            int currentSize = split + currentRemaining;
            if (currentRemaining > 0) {
                remaining--;
            }

            for (int j=0; j<currentSize; j++) {
                prev = current;
                if (current != null) {
                    current = current.next;
                }
            }

            if (prev != null) {
                prev.next = null;
            }
        }
        return ans;
    }
}
