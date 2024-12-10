package questions.leetcode;

public class SplitACircularLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode fast = list;
        ListNode slow = list;
        while (fast.next != list && fast.next.next != list) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = list;
        ListNode head2 = slow.next;
        slow.next = head1;
        fast = head2;

        while(fast.next != list) {
            fast = fast.next;
        }

        fast.next = head2;
        return new ListNode[]{head1, head2};
    }
}
