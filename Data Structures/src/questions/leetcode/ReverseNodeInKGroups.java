package questions.leetcode;

public class ReverseNodeInKGroups {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr != null) {
            ListNode tracker = ptr;
            for (int i=0; i<k; i++) {
                if (tracker == null) {
                    break;
                }
                tracker = tracker.next;
            }


            if (tracker == null) {
                break;
            }

            ListNode[] updatedNodes = reverseList(ptr.next, k);
            ListNode prev = updatedNodes[0];
            ListNode curr = updatedNodes[1];

            ListNode lastNodeOfReversedOrder = ptr.next;
            lastNodeOfReversedOrder.next = curr;
            ptr.next = prev;
            ptr = lastNodeOfReversedOrder;
        }

        return dummy.next;
    }

    private ListNode[] reverseList(ListNode node, int k) {
        ListNode curr = node;
        ListNode next = null;
        ListNode prev = null;

        for (int i=0; i<k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return new ListNode[]{prev, curr};
    }
}
