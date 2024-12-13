package questions.leetcode;

public class ReverseNodesInEvenLength {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        ListNode curr = null;
        ListNode node = null;
        ListNode currNext = null;
        ListNode prevNext = null;
        ListNode reverse = null;

        int groupLen = 2;
        int numNodes = 0;

        while(prev.next != null) {
            node = prev;
            numNodes = 0;

            for(int i=0; i<groupLen; i++) {
                if (node.next == null) {
                    break;
                }
                numNodes++;
                node = node.next;
            }

            if (numNodes % 2 != 0) {
                prev = node;
            } else {
                reverse = node.next;
                curr = prev.next;

                for (int j=0; j<numNodes; j++) {
                    currNext = curr.next;
                    curr.next = reverse;
                    reverse = curr;
                    curr = currNext;
                }

                prevNext = prev.next;
                prev.next = node;
                prev = prevNext;
            }
            groupLen++;
        }
        return head;
    }
}
