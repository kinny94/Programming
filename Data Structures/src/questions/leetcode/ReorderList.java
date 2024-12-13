package questions.leetcode;

public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode firstHalfPoitner = head;
        ListNode secondHalfPointer= prev;
        ListNode temp = head;

        while(secondHalfPointer.next != null) {
            temp = temp.next;
            firstHalfPoitner.next = secondHalfPointer;
            secondHalfPointer = secondHalfPointer.next;
            firstHalfPoitner.next.next = temp;
            firstHalfPoitner = firstHalfPoitner. next.next;
        }
    }
}
